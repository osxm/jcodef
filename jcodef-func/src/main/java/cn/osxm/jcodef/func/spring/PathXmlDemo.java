/**
 * @Title: PathXmlDemo.java
 * @Package cn.osxm.jcodef.func.spring
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年12月24日 下午10:28:24
 * @version V1.0
 */

package cn.osxm.jcodef.func.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @ClassName: PathXmlDemo
 * @Description: TODO
 * @author osxm:oscarxueming
 */

public class PathXmlDemo {
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("cn/osxm/jcodef/func/spring/spring-beans.xml");
		UserService userService = (UserService) context.getBean("userService");
		System.out.println(userService.toString());

		context = new FileSystemXmlApplicationContext("classpath:cn/osxm/jcodef/func/spring/spring-beans.xml", "");
		userService = (UserService) context.getBean("userService");
		System.out.println(userService.toString());

	}
}
