/**
 * @Title: CryptographyTests.java
 * @Package cn.osxm.jcodef.shiro
 * @Description: TODO
 * @author oscarchen
 * @date 2019年11月6日
 * @version V1.0
 */
package cn.osxm.jcodef.shiro;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

/**
 * @ClassName: CryptographyTests
 * @Description: TODO
 * @author oscarchen
 */
public class CryptographyTests {
	@Test
	public void jdkMd5() throws NoSuchAlgorithmException {
		String s = "1";
		byte[] originBytes = s.getBytes();
		System.out.println("原始字节数组长度：" + originBytes.length); // 1
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.digest(s.getBytes());
		byte[] hashed = md.digest();
		System.out.println("MD5加密字节数组长度：" + hashed.length); // 16

		int b = originBytes[0] & 0x0f; // 0f是16进制 15， 00001111 高位补0
		System.out.println("b=" + b); // 1

		String hashStr = new String(hashed);
		System.out.println(hashStr);
	}
}
