/**
 * @Title: FileTests.java
 * @Package cn.osxm.jcodef.func.file
 * @Description: TODO
 * @author oscarchen
 * @date 2019年9月23日
 * @version V1.0
 */
package cn.osxm.jcodef.func.file;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * @ClassName: FileTests
 * @Description: TODO
 * @author oscarchen
 */
public class FileTests {

	@Test
	public void filePath() throws IOException {
		File file = new File("1.txt");
		String absfilePath = file.getAbsolutePath(); //D:\devworkspace\ecpworkspace\jcodef\jcodef-func\1.txt
		String filePath = file.getPath(); //1.txt
		String fileName = file.getName(); //1.txt
		String canonicalPath = file.getCanonicalPath();

		System.out.println(absfilePath);
		System.out.println(filePath);
		System.out.println(fileName);
		System.out.println(canonicalPath);
	}
}
