/**
 * @Title: FileIoType.java
 * @Package cn.osxm.jcodef.func.io
 * @Description: TODO
 * @author oscarchen
 * @date 2021年3月4日
 * @version V1.0
 */
package cn.osxm.jcodef.func.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @ClassName: FileIoType
 * @Description: TODO
 * @author oscarchen
 */
public class FileIoType {

	private static String fullFileName;
	private static String inFullFileName;
	private static String outFullFileName;

	/**
	 * JUnit 测试初始化方法， @BeforeClass 多个测试方法只会执行一次
	 */
	@BeforeClass
	public static void setupSingle() {
		String inFileName = "1.txt";
		String outFileName = "1_1.txt";
		File file = new File("");
		String projectPath = "";
		try {
			projectPath = file.getCanonicalPath(); // 项目根路径
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		inFullFileName = projectPath + File.separator + "files" + File.separator + inFileName;
		fullFileName = inFullFileName;
		outFullFileName = projectPath + File.separator + "files" + File.separator + outFileName;
	}

	/**
	 * JUnit 测试初始化方法， @Before 每个测试方法之前都只会执行
	 */
	@Before
	public void setup() throws IOException {
		File outFile = new File(outFullFileName);
		// if(outFile.exists()) {
		// outFile.delete();
		// }
		File file = new File(fullFileName);
		if (file.exists()) { //清空文件内容
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write("");
			fileWriter.flush();
			fileWriter.close();
		}
	}

	/**
	 * 字节流
	 */
	@Test
	public void byteStreamDemo() throws IOException {

		// 1.输出流
		File outFile = new File(outFullFileName);
		OutputStream out = new FileOutputStream(outFile); // 文件输出流
		out.write("输出流测试".getBytes());
		out.flush();
		out.close();

		// 2. 输入流
		File inFile = new File(inFullFileName);
		InputStream in = new FileInputStream(inFile); // 文件输入流
		byte[] b = new byte[1024];// 定义字节数组
		int len = in.read(b); // 从字节流中读取字节数据到字节数组， len是读取的长度， 如果该长度等于-1，即读取完成
		String str = new String(b, 0, len);
		System.out.println(str);
		in.close(); // 关闭输入流

	}

	/**
	 * 字符流
	 * 
	 * @throws IOException
	 */
	@Test
	public void charStreamDemo() throws IOException {
		String str = "Hello,Java IO";
		// File file = new File(inFullFileName); //1.txt
		Writer out = new FileWriter(inFullFileName);
		out.write(str);
		out.flush();
		out.close();

		FileReader fr = new FileReader(inFullFileName);
		int ichar = 0;
		while ((ichar = fr.read()) != -1) {
			System.out.print((char) ichar);
		}

	}

	/**
	 * 传统IO 的缓冲流
	 */
	@Test
	public void buffStreamDemo() throws IOException {
		File file = new File(fullFileName);
		// 1. 字节流缓冲
		// 1.1 字节输出流缓冲
		OutputStream out = new FileOutputStream(file);
		BufferedOutputStream bufOut = new BufferedOutputStream(out);
		bufOut.write("Hello,Buffer byte Stream".getBytes());
		bufOut.flush();
		bufOut.close();
		out.close();
		// 1.21 字节输入流缓冲
		InputStream in = new FileInputStream(file);
		BufferedInputStream bufIn = new BufferedInputStream(in);
		byte[] b = new byte[1024];
		bufIn.read();
		int len = 0;
		while ((len = bufIn.read(b, 0, len)) != -1) { // 如果读取没有完成
			String str = new String(b, 0, len);
			System.out.println(str);
		}
		bufIn.close();
		in.close();
	}
}
