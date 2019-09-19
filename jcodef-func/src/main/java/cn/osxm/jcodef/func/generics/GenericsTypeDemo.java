/**
 * @Title: GenericsTypeDemo.java
 * @Package cn.osxm.jcodef.func.generics
 * @Description: TODO
 * @author oscarchen
 * @date 2019年9月19日
 * @version V1.0
 */
package cn.osxm.jcodef.func.generics;

/**
 * @ClassName: GenericsTypeDemo
 * @Description: TODO
 * @author oscarchen
 */
public class GenericsTypeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// MyGenericsType myGenericsType = new MyGenericsType();
		// Class cls= myGenericsType.getActualClass();
		// ParameterizedType pt = (ParameterizedType)
		// myGenericsType.getClass().getGenericSuperclass();
		// Class clazz = (Class) pt.getActualTypeArguments()[0];
		// Class clazz = myGenericsType.getTClass();

		MyService myService = new MyService();
		System.out.println(myService.getActualClass());

	}

}
