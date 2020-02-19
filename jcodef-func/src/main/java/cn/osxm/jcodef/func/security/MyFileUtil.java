/**
 * @Title: MyFileUtil.java
 * @Package cn.osxm.jcodef.func.security
 * @Description: TODO
 * @author oscarchen
 * @date 2020年2月6日
 * @version V1.0
 */
package cn.osxm.jcodef.func.security;

import java.io.File;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * @ClassName: MyFileUtil
 * @Description: TODO
 * @author oscarchen
 */
public class MyFileUtil {
	private static String filePath = "D:\\temp";

	public static void newFile(String fileName) {
		String fullFileName = filePath + File.separator + fileName;
		try {
			File file = new File(fullFileName);
			file.createNewFile();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void newFileWithPrivilegedAction(String fileName) {
		AccessController.doPrivileged(new PrivilegedAction<String>() {
			@Override
			public String run() {
				newFile(fileName);
				return null;
			}
		});
	}
}
