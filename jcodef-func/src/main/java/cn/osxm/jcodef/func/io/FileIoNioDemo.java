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
import java.nio.charset.Charset;

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
	private String fullFileName = null;
	
	@Before
	public void setup() {
		String sourceFileName = "1.rar";
		String targetFileName = "1_1.rar";
		String fileName = "1.txt";
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
		fullFileName = projectPath + File.separator+"files"+File.separator+fileName;
		File targetFile = new File(targetFullFileName);
		if(targetFile.exists()) {
			targetFile.delete();
		}
		System.out.println("每个方法都会首先执行初始化");
	}
	
	
	@Test
	public void fileNio() throws Exception{
			FileInputStream fileInputStream = new FileInputStream(new File(fullFileName));
            FileChannel fileChannel = fileInputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            while(fileChannel.read(byteBuffer)>0){
                //将ByteBuffer从写模式转换为读取模式
            	// 实现方式是把position的位置变成0，limit的位置变成position。
                byteBuffer.flip();
                //打印缓冲区内容
                Charset charset = Charset.forName("UTF-8");
                System.out.println(charset.newDecoder().decode(byteBuffer).toString());
                //这里并不是清除缓冲区的数据，而是指针的位移。把position为0，把limit为缓冲区的容量大小
                byteBuffer.clear();
            }
            fileChannel.close();
            fileInputStream.close();
	}
	
	
	//@Test
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
	
	//@Test
	public void writeFileUseNio() throws Exception{
		long lBegin = System.currentTimeMillis();
		FileInputStream fileInputStream = new FileInputStream(new File(sourceFullFileName));
		FileChannel inChannel = fileInputStream.getChannel();//获取输入通道
		FileOutputStream fileOutputStream = new FileOutputStream(new File(targetFullFileName));
		FileChannel outChannel = fileOutputStream.getChannel();//获取输出通道
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);  //字节缓冲区
		while(true) {
			int eof = inChannel.read(byteBuffer); //从通道读取数据到字节数组
			if (eof == -1)
				break;
			byteBuffer.flip(); //将postion复位到0
			outChannel.write(byteBuffer); //写入通道
			byteBuffer.clear(); //
		}
		inChannel.close();
		fileInputStream.close();
		outChannel.close();
		fileOutputStream.close();
		long lEnd =  System.currentTimeMillis();
	    System.out.println("NIO花费时间："+(lEnd-lBegin)+"毫秒");
	}
}
