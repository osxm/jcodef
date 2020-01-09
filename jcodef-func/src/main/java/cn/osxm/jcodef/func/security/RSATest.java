/**
 * @Title: RSATest.java
 * @Package cn.osxm.jcodef.func.security
 * @Description: TODO
 * @author oscarchen
 * @date 2020年1月9日
 * @version V1.0
 */
package cn.osxm.jcodef.func.security;

import java.util.Map;

import org.junit.Test;

/**
 * @ClassName: RSATest
 * @Description: TODO
 * @author oscarchen
 */
public class RSATest {
	// @Test
	public void createKeys() {
		Map<String, String> keyMap = RSAUtil.createKeys(1024);
		String publicKey = keyMap.get("publicKey");
		String privateKey = keyMap.get("privateKey");
		System.out.println("公钥: \n\r" + publicKey);
		System.out.println("私钥： \n\r" + privateKey);
	}

	@Test
	public void EnDeCrypt() throws Exception {
		System.out.println("公钥加密——私钥解密");
		String str = "Hello,RSA.";
		Map<String, String> keyMap = RSAUtil.createKeys(1024);
		String publicKey = keyMap.get("publicKey");
		String privateKey = keyMap.get("privateKey");
		System.out.println("明文：" + str);
		System.out.println("明文大小：" + str.getBytes().length);
		String encodedData = RSAUtil.publicEncrypt(str, RSAUtil.getPublicKey(publicKey));
		System.out.println("密文：" + encodedData);
		String decodedData = RSAUtil.privateDecrypt(encodedData, RSAUtil.getPrivateKey(privateKey));
		System.out.println("解密后文字: " + decodedData);
	}
}
