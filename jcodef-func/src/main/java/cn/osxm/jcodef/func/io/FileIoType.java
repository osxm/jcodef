/**
 * @Title: FileIoType.java
 * @Package cn.osxm.jcodef.func.io
 * @Description: TODO
 * @author oscarchen
 * @date 2021年3月4日
 * @version V1.0
 */
package cn.osxm.jcodef.func.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Before;
import org.junit.BeforeClass;

/**
  * @ClassName: FileIoType
  * @Description: TODO
  * @author oscarchen
  */
public class FileIoType {
	
	private String inFileFullName;
	private String outFileFullName;
	
	
	/**
	 * JUnit 测试初始化方法， @BeforeClass 多个测试方法只会执行一次
	 */
	@BeforeClass
	public void setupSingle() {
		String inFileName = "1.txt";
		String outFileName = "1_1.txt";
		File file = new File("");
		String projectPath = "";
		try {
			projectPath = file.getCanonicalPath();  //项目根路径
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		inFileFullName = projectPath + File.separator +"files"+File.separator+inFileName;
		outFileFullName = projectPath + File.separator+"files"+File.separator+outFileName;
	}
	
	
	
	/**
	 * JUnit 测试初始化方法， @Before 每个测试方法之前都只会执行
	 */	
	@Before
	public void setup() {
		File outFile = new File(outFileFullName);
		if(outFile.exists()) {
			outFile.delete();
		}
	}

	/**
	 * 字节流
	 */
	public void streamDemo() throws IOException {
		File inFile = new File(inFileFullName);
		FileInputStream in = new FileInputStream(inFile); //文件输入流
		byte[] b = new byte[1024];//定义字节数组
		int len = in.read(b); //从字节流中读取字节数据到字节数组， len是读取的长度， 如果该长度等于-1，即读取完成
		in.close(); //关闭输入流
		
		
		
		
	}
}
