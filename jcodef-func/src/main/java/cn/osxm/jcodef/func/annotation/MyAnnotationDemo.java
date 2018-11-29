/**
 * @Title: MyAnnotationDemo.java
 * @Package cn.osxm.jcodef.func.annotation
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年11月30日 上午5:40:16
 * @version V1.0
 */

package cn.osxm.jcodef.func.annotation;

/**
 * @ClassName: MyAnnotationDemo
 * @Description: TODO
 * @author osxm:oscarxueming
 */
@MyAnnotation
public class MyAnnotationDemo {

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 */

	public static void main(String[] args) {
		if (MyAnnotationDemo.class.isAnnotationPresent(MyAnnotation.class)) {
			MyAnnotation annotation = (MyAnnotation) MyAnnotationDemo.class.getAnnotation(MyAnnotation.class);
			System.out.println(annotation);
		}
	}
}
