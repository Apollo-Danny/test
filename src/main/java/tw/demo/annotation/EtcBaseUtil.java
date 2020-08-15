package tw.demo.annotation;

import java.net.InetAddress;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: EtcBaseUtil
 * @date Apr 3, 2019 1:50:20 PM
 * @author ToniR
 * @Description: 工具类
 */
public class EtcBaseUtil {

	/**
	 * 正则检查
	 * 
	 * @param reg
	 * @param string
	 * @return boolean
	 */
	public static boolean regCheck(String reg, String string) {
		boolean tem = false;
		try {
			Pattern pattern = Pattern.compile(reg);
			Matcher matcher = pattern.matcher(string);
			tem = matcher.matches();
		} catch (Exception se) {
			se.printStackTrace();
		}
		return tem;
	}

	/**
	 * 获取本机IP
	 * 
	 * @return String
	 */
	public static String getLocIp() {
		String localip = "";
		InetAddress ia = null;
		try {
			ia = InetAddress.getLocalHost();
			localip = ia.getHostAddress();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return localip;
	}

	/**
	 * 添加手机号检查，检查手机号是否正确
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isMobile(String str) {
		boolean b = false;
		b = PatternConfig.MOBILE_PATTERN.matcher(str).matches();
		return b;
	}

	public static String leftAddZero(int source, int len) {
		return String.format("%0" + len + "d", source);
	}

	/**
	 * 二进制转字符串
	 *
	 * @param
	 * @return str
	 */
	public static String byte2hex(byte[] b) {
		StringBuffer sb = new StringBuffer();
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = Integer.toHexString(b[n] & 0XFF);
			if (stmp.length() == 1) {
				sb.append("0" + stmp);
			} else {
				sb.append(stmp);
			}

		}
		return sb.toString();
	}

	/**
	 * 字符串转二进制
	 *
	 * @param str
	 * @return byte[]
	 */
	public static byte[] hex2byte(String str) {
		if (str == null) {
			return null;
		}

		str = str.trim();
		int len = str.length();
		if (len == 0 || len % 2 == 1) {
			return null;
		}

		byte[] b = new byte[len / 2];
		try {
			for (int i = 0; i < str.length(); i += 2) {
				b[i / 2] = (byte) Integer.decode("0X" + str.substring(i, i + 2)).intValue();
			}
			return b;
		} catch (Exception e) {
			return null;
		}
	}

}
