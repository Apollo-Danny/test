package tw.demo.demo;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class MD5Utils {

    private static final Logger LOGGER = LoggerFactory.getLogger(MD5Utils.class);
    public static boolean isLog = false;
    private static String CHARSET = "UTF-8";

    /**
     * 只对第一层数据进行排序组建签名字符串，List和map的value转成字符串
     *
     * @param parameters
     * @param filename
     * @param key
     * @return
     */
    public static String generateEtcCustomerSignSrc(Map<String, Object> parameters, String filename, String key) {
        List<Map.Entry<String, Object>> infoIds = new ArrayList<Map.Entry<String, Object>>(parameters.entrySet());
        // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
        Collections.sort(infoIds, new Comparator<Map.Entry<String, Object>>() {
            public int compare(Map.Entry<String, Object> o1, Map.Entry<String, Object> o2) {
                return (o1.getKey()).toString().compareTo(o2.getKey());
            }
        });
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, Object> item : infoIds) {
            String k = item.getKey();
            Object v = item.getValue();
            if (null != v && !"".equals(v) && !"sign".equals(k)
                    && !"key".equals(k)) {
                if (v instanceof Date) {
                    v = DateUtils.date((Date) v, DateUtils.TIMESTAMP_LETTER_T_FORMAT);
                } else if (v instanceof List | v instanceof Map) {
                    v = JSONObject.toJSON(v);
                }
                sb.append(k.trim() + "=" + v + "&");
            }
        }
        sb.append("filename=" + filename);
            sb.append("&key=" + key);

        String signSrc = sb.toString();
        if (isLog)
            LOGGER.info("用于签名的临时字符串:" + signSrc);

        return signSrc;
    }

    public static String md5(String text) {
        byte[] bytes = new byte[0];
        try {
            bytes = text.getBytes(CHARSET);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return md5(bytes);
    }

    public static String md5(byte[] bytes) {
        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        try {

            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(bytes);
            // 获得密文
            byte[] md = digest.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            String sign = new String(str);
            if (isLog)
                LOGGER.info("系统生成的用于校验的sign（MD5值）:" + sign);

            return sign;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static String getFjgstMD5Str(Map<String, Object> map, String key) {
        List<Map.Entry<String, Object>> keys = new ArrayList<Map.Entry<String, Object>>(map.entrySet());
        // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
        Collections.sort(keys, new Comparator<Map.Entry<String, Object>>() {
            public int compare(Map.Entry<String, Object> o1, Map.Entry<String, Object> o2) {
                return (o1.getKey()).toString().compareTo(o2.getKey());
            }
        });

        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, Object> item : keys) {
            String k = item.getKey();
            Object v = item.getValue();
            if (StringUtils.isNotEmpty(k) && null != v && !"".equals(v) && !"sign".equals(k) && !"signType".equals(k)) {
                if (v instanceof Date) {
                    v = DateUtils.date((Date) v, DateUtils.TIMESTAMP_LETTER_T_FORMAT);
                } else if (v instanceof List | v instanceof Map) {
                    if (v instanceof List) {
                        List l = (List) v;
                        v = getFjgstListMD5(l);
                    } else {
                        v = getFjgstMD5Str((Map<String, Object>) v, null);
                    }
                }
                sb.append(k.trim() + "=" + v + "&");
            }
        }
        if (sb.length() > 0)
            sb.delete(sb.length() - 1, sb.length());

        if (StringUtils.isNotEmpty(key))
            sb.append("&key=" + key);
        String src = sb.toString();
        LOGGER.info(String.format("签名源字符串:%s", src));
        return src;
    }

    private static String getFjgstListMD5(List l) {
        StringBuffer sb = new StringBuffer();
        if (l.size() > 0) {
            if (l.get(0) instanceof Map) {
                for (int i = 0; i < l.size(); i++) {
                    sb.append(getFjgstMD5Str((Map<String, Object>) l.get(i), null) + "&");
                }
                sb.delete(sb.length() - 1, sb.length());
            } else if (l.get(0) instanceof List) {
                sb.append(getFjgstListMD5(l));
            } else {
                for (int i = 0; i < l.size(); i++) {
                    sb.append(l.get(i) + "&");
                }
                sb.delete(sb.length() - 1, sb.length());
            }
        }
        return sb.toString();
    }
}
