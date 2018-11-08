/**
 * @Title: EhcacheUse.java
 * @Package cn.osxm.jcodef.func.ehcache
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年11月8日 下午8:27:20
 * @version V1.0
 */

package cn.osxm.jcodef.func.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * @ClassName: EhcacheUse
 * @Description: TODO
 * @author osxm:oscarxueming
 */

public class EhcacheDemo {
	public static void main(String[] args) {

		EhcacheDemo ehcacheUse = new EhcacheDemo();
		// 1. 缓存管理器
		CacheManager cacheManager = CacheManager
				.create(ehcacheUse.getClass().getResource("").getPath() + "ehcache.xml");

		// 2. 获取缓存对象
		Cache cache = cacheManager.getCache("HelloWorldCache");

		// 3. 创建需要缓存的元素
		Element element = new Element("cachekey1", "cache value 1");

		// 4.将元素加入缓存
		cache.put(element);

		// 5. 获取缓存里的元素
		Element value = cache.get("cachekey1");
		System.out.println(value);
		System.out.println(value.getObjectValue());

		// 6. 删除缓存元素
		cache.remove("cachekey1");

		// 7. 刷新缓存
		cache.flush();

		// 8. 关闭缓存管理器
		cacheManager.shutdown();

	}
}
