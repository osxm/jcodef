/**
 * @Title: BasicUsageTests.java
 * @Package cn.osxm.jcodef.library.guava
 * @Description: TODO
 * @author oscarchen
 * @date 2019年10月26日
 * @version V1.0
 */
package cn.osxm.jcodef.library.guava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

/**
 * @ClassName: BasicUsageTests
 * @Description: TODO
 * @author oscarchen
 */
public class BasicUsageTests {
	@Test // List使用对比
	public void list() {
		List<String> javaList = new ArrayList<String>();
		javaList.add("Java Standard List");
		List<String> guavaList = Lists.newArrayList();
		guavaList.add("Google Guava List");
		System.out.println(javaList.toString());
		System.out.println(guavaList.toString());
	}

	@SuppressWarnings("unused")
	@Test
	public void collections() {
		List<String> list = Lists.newArrayList();
		Set<String> set = Sets.newHashSet();
		Map<String, String> map = Maps.newHashMap();
	}

	@SuppressWarnings("unused")
	@Test // 不可变集合
	public void immutableCollections() {
		ImmutableList<String> iList = ImmutableList.of("a", "b", "c");
		ImmutableSet<String> iSet = ImmutableSet.of("a", "b", "c");
		ImmutableMap<String, String> iMap = ImmutableMap.of("key1", "value1", "key2", "value2");
	}

	@Test // Map的元素是List类型
	public void mapList() {
		// JDK标准处理
		Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		map.put("test", list);

		// Guava处理
		Multimap<String, Integer> mapM = ArrayListMultimap.create();
		mapM.put("test", 1);
		mapM.put("test", 2);
	}

	@Test // Joiner 字符串连接
	public void stringJoin() {
		StringBuilder stringBuilder = new StringBuilder("开始：");
		Joiner joiner = Joiner.on("|").skipNulls(); // 设置连接符，忽略空对象
		stringBuilder = joiner.appendTo(stringBuilder, "1", "2", null, "3", "4", "5");
		System.out.println(stringBuilder.toString());
	}

	@Test // Map转换为字符串
	public void mapToString() {
		Map<String, String> map = Maps.newLinkedHashMap();
		map.put("Key1", "Value1");
		map.put("Key2", "Value2");
		String returnedString = Joiner.on("#").withKeyValueSeparator(":").join(map); // #分隔键值，:分隔元素
		System.out.println(returnedString);
	}

	@Test
	public void stringToMap() {
		String str = "Key1:Value1#Key2:Value2";
		Splitter.MapSplitter ms = Splitter.on("#").withKeyValueSeparator(':');
		Map<String, String> map = ms.split(str);
		for (String key : map.keySet()) {
			System.out.println(key + " -> " + map.get(key));
		}
	}

	@Test
	public void strings() {
		// 字符串是否为null或空字串
		System.out.println(Strings.isNullOrEmpty(""));
		System.out.println(Strings.isNullOrEmpty(null));
		// 从null转为空字串
		System.out.println(Strings.nullToEmpty(null));
		// 字符串开始处补充到指定长度
		System.out.println(Strings.padStart("hello", 8, 'T'));
		// 字符串尾部补充道指定长度
		System.out.println(Strings.padEnd("hello", 8, 'T'));
	}

	@Test // 字符匹配和替换
	public void charMatcher() {
		String str = "空格    换行\r 换行\r\n  制表符\t";
		str = CharMatcher.breakingWhitespace().replaceFrom(str, '#');
		System.out.println(str);
	}
}
