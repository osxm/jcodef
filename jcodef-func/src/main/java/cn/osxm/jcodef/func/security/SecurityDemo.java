/**
 * @Title: SecurityDemo.java
 * @Package cn.osxm.jcodef.func.security
 * @Description: TODO
 * @author oscarchen
 * @date 2020年2月6日
 * @version V1.0
 */
package cn.osxm.jcodef.func.security;

import java.io.File;

/**
 * @ClassName: SecurityDemo
 * @Description: TODO
 * @author oscarchen
 */
public class SecurityDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String fullFileName = "D:\\temp\\1.txt";
		//System.setSecurityManager(new SecurityManager());//开启沙箱
		try {
			File file = new File(fullFileName);
			file.createNewFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
