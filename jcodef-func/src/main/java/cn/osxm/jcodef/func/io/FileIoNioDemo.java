/**
 * @Title: FileIoNioDemo.java
 * @Package cn.osxm.jcodef.func.io
 * @Description: TODO
 * @author oscarchen
 * @date 2021年3月2日
 * @version V1.0
 */
package cn.osxm.jcodef.func.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Before;
import org.junit.Test;

/**
  * @ClassName: FileIoNioDemo
  * @Description: TODO
  * @author oscarchen
  */
public class FileIoNioDemo {

	private String sourceFullFileName = null;
	private String targetFullFileName = null;
	
	@Before
	public void setup() {
		String sourceFileName = "1.rar";
		String targetFileName = "1_1.rar";
		File file = new File("");
		String projectPath = "";
		try {
			projectPath = file.getCanonicalPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sourceFullFileName = projectPath + File.separator +"files"+File.separator+sourceFileName;
		targetFullFileName = projectPath + File.separator+"files"+File.separator+targetFileName;
		File targetFile = new File(targetFullFileName);
		if(targetFile.exists()) {
			targetFile.delete();
		}
		System.out.println("每个方法都会首先执行初始化");
	}
	
	
	@Test
	public void writeFileUseIo() throws Exception{
		long lBegin = System.currentTimeMillis();
		FileInputStream fileInputStream = new FileInputStream(new File(sourceFullFileName));
		FileOutputStream fileOutputStream = new FileOutputStream(new File(targetFullFileName));
		byte[] buf = new byte[1024];
		int len = 0;
		while((len = fileInputStream.read(buf))!= -1) {
			fileOutputStream.write(buf,0,len);
			fileOutputStream.flush();
		}
		fileOutputStream.close();
		fileInputStream.close();
	    long lEnd =  System.currentTimeMillis();
	    System.out.println("传统IO花费时间："+(lEnd-lBegin)+"毫秒");
	}
	
	@Test
	public void writeFileUseNio() throws Exception{
		long lBegin = System.currentTimeMillis();
		FileInputStream fileInputStream = new FileInputStream(new File(sourceFullFileName));
		FileChannel inChannel = fileInputStream.getChannel();
		FileOutputStream fileOutputStream = new FileOutputStream(new File(targetFullFileName));
		FileChannel outChannel = fileOutputStream.getChannel();
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);  
		while(true) {
			int eof = inChannel.read(byteBuffer);
			if (eof == -1)
				break;
			byteBuffer.flip();
			outChannel.write(byteBuffer);
			byteBuffer.clear();
		}
		inChannel.close();
		fileInputStream.close();
		outChannel.close();
		fileOutputStream.close();
		long lEnd =  System.currentTimeMillis();
	    System.out.println("NIO花费时间："+(lEnd-lBegin)+"毫秒");
	}
}
