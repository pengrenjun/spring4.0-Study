package Utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.SecureRandom;

public class DESUtils {

	/*指定des加密所用的秘钥*/
	private static Key key;
	private static String KEY_STR = "myKey";
	static {
		try {
			KeyGenerator generator = KeyGenerator.getInstance("DES");
			generator.init(new SecureRandom(KEY_STR.getBytes()));
			key = generator.generateKey();
			generator = null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 对str进行DES加密,返回BASE64编码的加密字符串
	 * 
	 * @param str
	 * @return
	 */
	public static String getEncryptString(String str) {
		BASE64Encoder base64en = new BASE64Encoder();
		try {
			byte[] strBytes = str.getBytes("UTF8");
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] encryptStrBytes = cipher.doFinal(strBytes);
			return base64en.encode(encryptStrBytes);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 对str进行DES解密
	 * 
	 * @param str
	 * @return
	 */
	public static String getDecryptString(String str) {
		BASE64Decoder base64De = new BASE64Decoder();
		try {
			byte[] strBytes = base64De.decodeBuffer(str);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decryptStrBytes = cipher.doFinal(strBytes);
			return new String(decryptStrBytes, "UTF8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public static void main(String[] args) throws Exception {
		/*	driverClassName=com.mysql.jdbc.Driver
			url=jdbc:mysql://localhost:3306/springstudy
			username=root
			password=*/
		System.out.println(DESUtils.getEncryptString("com.mysql.jdbc.Driver"));
		System.out.println(DESUtils.getEncryptString("jdbc:mysql://localhost:3306/springstudy"));
		System.out.println(DESUtils.getEncryptString("root"));
		System.out.println(DESUtils.getEncryptString(""));

		System.out.println(DESUtils.getDecryptString("8zQIdS8RzOC17FZcjyxoF7kDqN4YEC2P"));
		System.out.println(DESUtils.getDecryptString("xW6OiZLo8/kovRmik6fHk1TAEBPOodYY/F2rWsxfJ92/yp2BfzZNjg=="));
		System.out.println(DESUtils.getDecryptString("WnplV/ietfQ="));
		System.out.println(DESUtils.getDecryptString("HyQH1bD/jNs="));


	}
}
