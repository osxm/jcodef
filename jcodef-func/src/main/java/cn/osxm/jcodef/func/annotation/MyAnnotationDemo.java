/**
 * @Title: MyAnnotationDemo.java
 * @Package cn.osxm.jcodef.func.annotation
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年11月30日 上午5:40:16
 * @version V1.0
 */

package cn.osxm.jcodef.func.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassName: MyAnnotationDemo
 * @Description: TODO
 * @author osxm:oscarxueming
 */
@MyAnnotation
public class MyAnnotationDemo {

	@MyAnnotation
	public void annoMethod() {
		System.out.println("方法本身执行");
	}

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */

	public static void main(String[] args) throws Exception {
		MyAnnotationDemo myAnnotationDemo = new MyAnnotationDemo();
		// 类
		if (myAnnotationDemo.getClass().isAnnotationPresent(MyAnnotation.class)) {
			MyAnnotation annotation = (MyAnnotation) myAnnotationDemo.getClass().getAnnotation(MyAnnotation.class);
			System.out.println(annotation);
			Field field = myAnnotationDemo.getClass().getField("");
			field.getAnnotations();
		}

		// 方法
		Method annoMethod = myAnnotationDemo.getClass().getMethod("annoMethod");
		annoMethod.invoke(myAnnotationDemo, null);
		Annotation[] methodAnnotations = annoMethod.getAnnotations();
		if (annoMethod.isAnnotationPresent(MyAnnotation.class)) {
			System.out.println("方法添加了MyAnnotation注解，再干点其他事.....");
		}

	}
}
