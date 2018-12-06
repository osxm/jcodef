/**
 * @Title: CglibProxy.java
 * @Package cn.osxm.jcodef.func.aop.cglib
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年12月4日 下午10:17:31
 * @version V1.0
 */

package cn.osxm.jcodef.func.aop.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @ClassName: CglibProxy
 * @Description: TODO
 * @author osxm:oscarxueming
 */

public class CglibProxy implements MethodInterceptor {
	private Enhancer enhancer = new Enhancer();

	public Object getProxy(Class clazz) {
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		return enhancer.create();
	}

	public Object intercept(Object obj, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("前置代理");
		Object result = methodProxy.invokeSuper(obj, objects);
		System.out.println("后置代理");
		return result;
	}

}
