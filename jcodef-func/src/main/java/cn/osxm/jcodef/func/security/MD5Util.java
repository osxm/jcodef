/**
 * @Title: MD5Util.java
 * @Package cn.osxm.jcodef.func.security
 * @Description: TODO
 * @author oscarchen
 * @date 2019年11月6日
 * @version V1.0
 */
package cn.osxm.jcodef.func.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName: MD5Util
 * @Description: TODO
 * @author oscarchen
 */
public class MD5Util {
	public static String md5digest(String str) {
		String encryptStr = null;
		try {
			// 方法1
			// byte[] bytes = MessageDigest.getInstance("MD5").digest(str.getBytes());
			// //长度16的字节数组
			// 方法2
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte[] bytes = md.digest();

			StringBuffer buffer = new StringBuffer(bytes.length * 2);
			for (int i = 0; i < bytes.length; i++) { // 每个循环产生2个字符
				if (((int) bytes[i] & 0xff) < 0x10)
					buffer.append("0"); // 小于16， 只有一位，则补0
				// buffer.append(Long.toString((int) bytes[i] & 0xff, 16)); //int 32bit, 使用&，
				// 高24位置0
				// buffer.append(Long.toHexString((int) bytes[i] & 0xff));
				buffer.append(Integer.toHexString((int) bytes[i] & 0xff));
			}
			encryptStr = buffer.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return encryptStr;
	}

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 */

	public static void main(String[] args) {
		String encryptStr = MD5Util.md5digest("1");
		System.out.println(encryptStr);
	}
}
