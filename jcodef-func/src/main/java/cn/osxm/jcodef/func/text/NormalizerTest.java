/**
 * @Title: NormalizerTest.java
 * @Package cn.osxm.jcodef.func.text
 * @Description: TODO
 * @author oscarchen
 * @date 2020年4月5日
 * @version V1.0
 */
package cn.osxm.jcodef.func.text;

import java.text.Normalizer;

import org.junit.Assert;
import org.junit.Test;

/**
 * @ClassName: NormalizerTest
 * @Description: TODO
 * @author oscarchen
 */
public class NormalizerTest {
	// á
	@Test
	public void base() {
		// 归一化前
		String str1 = "\u00C1";
		System.out.println(str1);

		String str2 = "\u0041" + "\u0301";
		System.out.println(str2);

		// Assert.assertTrue(str1.equals(str2)); //失败

		// 归一化后
		str1 = Normalizer.normalize(str1, Normalizer.Form.NFC);
		str2 = Normalizer.normalize(str2, Normalizer.Form.NFC);
		System.out.println(str1);
		System.out.println(str2);
		Assert.assertTrue(str1.equals(str2)); // 成功
	}
}
