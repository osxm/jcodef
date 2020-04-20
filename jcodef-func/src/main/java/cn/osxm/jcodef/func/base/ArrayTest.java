/**
 * @Title: ArrayTest.java
 * @Package cn.osxm.jcodef.func.base
 * @Description: TODO
 * @author oscarchen
 * @date 2020年4月21日
 * @version V1.0
 */
package cn.osxm.jcodef.func.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

/**
 * @ClassName: ArrayTest
 * @Description: TODO
 * @author oscarchen
 */
public class ArrayTest {

	@Test
	public void test() {
		List<String> list = new ArrayList<String>();
		list.add("aaa");
		System.out.println(list.toString());
	}

	@Test
	public void init() {
		List<String> list = Arrays.asList("A", "B");
		Assert.assertTrue(list.size() == 2);

		list = Stream.of("A", "B").collect(Collectors.toList());
		Assert.assertTrue(list.size() == 2);

		Assert.assertTrue(list.size() == 2);

	}

}
