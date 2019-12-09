/**
 * @Title: FileStreamDemo.java
 * @Package cn.osxm.jcodef.func.io
 * @Description: TODO
 * @author oscarchen
 * @date 2019年12月9日
 * @version V1.0
 */
package cn.osxm.jcodef.func.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;

/**
 * @ClassName: FileStreamDemo
 * @Description: TODO
 * @author oscarchen
 */
public class FileStreamDemo {
	private String classRootPath = FileStreamDemo.class.getResource("/").getPath();

	private String filePath = classRootPath + "file1.txt";

	// @Test
	public void inputStreamToString() throws Exception {
		// OutputStream os = new FileOutputStream(filePath);
		InputStream is = new FileInputStream(filePath);
		InputStreamReader isr = new InputStreamReader(is);
		int ch;
		while ((ch = isr.read()) != -1) {
			System.out.println((char) ch);
		}
		isr.close();
	}

	@Test
	public void bufferInputStreamToString() throws Exception {
		// OutputStream os = new FileOutputStream(filePath);
		InputStream is = new FileInputStream(filePath);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String str = null;
		while ((str = br.readLine()) != null) {
			System.out.println(str);
		}
		br.close();
		isr.close();
	}

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 */

	public static void main(String[] args) throws Exception {

	}

}
