/**
 * @Title: CglibDemo.java
 * @Package cn.osxm.jcodef.func.aop.cglib
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年12月4日 下午10:20:19
 * @version V1.0
 */

package cn.osxm.jcodef.func.aop.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
  * @ClassName: CglibDemo
  * @Description: TODO
  * @author osxm:oscarxueming
  */

public class CglibDemo {
	

	/**
	  * @Title: main
	  * @Description: TODO
	  * @param args
	  */

	public static void main(String[] args) {
		CglibProxy proxy = new CglibProxy();
		HelloService proxyImp = (HelloService)proxy.getProxy(HelloService.class);
        proxyImp.sayHello();

	}

}
