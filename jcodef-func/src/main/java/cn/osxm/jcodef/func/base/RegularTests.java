/**
 * @Title: RegularTests.java
 * @Package cn.osxm.jcodef.func.base
 * @Description: TODO
 * @author oscarchen
 * @date 2020年9月16日
 * @version V1.0
 */
package cn.osxm.jcodef.func.base;

import java.util.regex.Pattern;

import org.junit.Test;
import org.wildfly.common.Assert;

/**
  * @ClassName: RegularTests
  * @Description: TODO
  * @author oscarchen
  */
public class RegularTests {
	
	@Test
	public void basic() {
		String regex = "^my\\d{3}";//my + 3个数字
		String str = "my123";
		boolean isMatch = Pattern.matches(regex, str);
		Assert.assertTrue(isMatch);
	}

}
