import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

/*import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;*/

public class AESUtil {

    /*public static void main(String[] args) throws Exception {
        try {
            String str = URLEncoder.encode("a12345", "UTF-8");
            System.out.println(str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //秘钥
        //String key = "022274384d81854c0d05fa0a0c32a7c3";
        String key = "0c2e4656c4d8c147dd8c854ad095faf6";
        //待加密内容
        String value = "Guanli2011";
        //加密后的密文
        String cipher = encrypt(value, key);
        System.out.println("密文是：" + cipher);
        //解密后的原文
        //String decrypt = decrypt(cipher, key);
        String decrypt = decrypt("U2FsdGVkX19/Zt0XVogNLdEyQPBfzjdDgeuf1JFghE0=", key);
        System.out.println("原文是：" + decrypt);
    }*/

    /**
     * AES加密
     *
     * @param content   需要加密的内容
     * @param secureKey 加密秘钥
     */
    public static String encrypt(String content, String secureKey) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");

            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(secureKey.getBytes());
            kgen.init(128, secureRandom);

            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] byteContent = content.getBytes("utf-8");
            byte[] result = cipher.doFinal(byteContent);

            return encodeBASE64(result);
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * AES解密
     *
     * @param content   待解密内容
     * @param secureKey 秘钥
     */
    public static String decrypt(String content, String secureKey) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");

            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(secureKey.getBytes());
            kgen.init(128, secureRandom);

            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();

            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);

            byte[] base64Dec = Base64.decode(content);
            byte[] result = cipher.doFinal(base64Dec);

            return new String(result);
        } catch (Exception e) {
            return null;
        }
    }

    public static String encodeBASE64(byte[] content) throws Exception {
        if (content == null || content.length == 0) {
            return null;
        }
        try {
            return Base64.encode(content);
        } catch (Exception e) {
            return null;
        }
    }
}
