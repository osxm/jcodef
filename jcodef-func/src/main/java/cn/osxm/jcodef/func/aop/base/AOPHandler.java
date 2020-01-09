/**
 * @Title: AOPHandler.java
 * @Package cn.osxm.jcodef.func.aop.base
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年12月4日 下午10:04:51
 * @version V1.0
 */

package cn.osxm.jcodef.func.aop.base;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName: AOPHandler
 * @Description: TODO
 * @author osxm:oscarxueming
 */

public class AOPHandler implements InvocationHandler {
	private Object obj;

	AOPHandler(Object obj) {
		this.obj = obj;
	}

	/**
	 * Title: invoke Description:
	 * 
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @return
	 * @throws Throwable
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object,
	 *      java.lang.reflect.Method, java.lang.Object[])
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("前置代理");
		Object ret = method.invoke(obj, args);
		System.out.println("后置代理");
		return ret;
		}

}
