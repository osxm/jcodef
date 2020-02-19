/**
 * @Title: CommonCMdTest.java
 * @Package cn.osxm.jcodef.func.security
 * @Description: TODO
 * @author oscarchen
 * @date 2020年2月5日
 * @version V1.0
 */
package cn.osxm.jcodef.func.security;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import org.junit.Test;



/**
  * @ClassName: CommonCMdTest
  * @Description: TODO
  * @author oscarchen
  */
public class CommonCMdTest {


	
	//@Test
	public void md5() {
		String str = "123456";
		String mdExpect = "e10adc3949ba59abbe56e057f20f883e";
		String mdActual = DigestUtils.md5Hex(str);
		Assert.assertTrue(mdActual.equals(mdExpect));
	}
	
	//@Test
	public void sha1() {
		String str = "123456";
		String mdExpect = "7c4a8d09ca3762af61e59520943dc26494f8941b";
		String mdActual = DigestUtils.sha1Hex(str);
		DigestUtils.sha256(str);
		DigestUtils.sha384(str);
		DigestUtils.sha512(str);
		Assert.assertTrue(mdActual.equals(mdExpect));
	}
	
	
	
	@Test
	public void md5file() throws Exception {
		String path = this.getClass().getResource("").getPath();
		String mdExpect = "e10adc3949ba59abbe56e057f20f883e";
        InputStream is = new FileInputStream(new File(path+File.separator+"1.txt")); //文件内容123456， 和相同String产生的消息摘要相同
		String mdActual = DigestUtils.md5Hex(is);
		Assert.assertTrue(mdActual.equals(mdExpect));
	}
}
