/**
 * @Title: AOPDemo.java
 * @Package cn.osxm.jcodef.func.aop.base
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年12月4日 下午10:06:53
 * @version V1.0
 */

package cn.osxm.jcodef.func.aop.base;

import java.lang.reflect.Proxy;

/**
 * @ClassName: AOPDemo
 * @Description: TODO
 * @author osxm:oscarxueming
 */

public class AOPDemo {

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 */

	public static void main(String[] args) {

		HelloServiceImpl helloServiceImpl = new HelloServiceImpl();
		AOPHandler aopHandler = new AOPHandler(helloServiceImpl);
		HelloService helloService = (HelloService) Proxy.newProxyInstance(HelloServiceImpl.class.getClassLoader(),
				new Class[] { HelloService.class }, aopHandler);
		helloService.sayHello();

	}

}
