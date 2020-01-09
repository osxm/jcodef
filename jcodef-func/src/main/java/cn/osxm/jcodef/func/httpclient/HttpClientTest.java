/**
 * @Title: HttpClientTest.java
 * @Package cn.osxm.jcodef.func.httpclient
 * @Description: TODO
 * @author oscarchen
 * @date 2020年1月9日
 * @version V1.0
 */

package cn.osxm.jcodef.func.httpclient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;

/**
 * @ClassName: HttpClientDemo
 * @Description: TODO
 * @author oscarchen
 */

public class HttpClientTest {

	@Test
	public void timeOut() throws Exception {
		String urlPath = "https://www.baidu.com/";
		URL url = new URL(urlPath); // 通过地址创建URL对象
		HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // 建立HTTP连接
		conn.setConnectTimeout(1000);
		InputStream is = conn.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String str = null;
		while ((str = br.readLine()) != null) { // 按行读取
			System.out.println(str);
		}
		br.close();
		isr.close();
		is.close();
	}

	public static void main(String[] args) throws Exception {
		String urlPath = "https://www.baidu.com/";
		URL url = new URL(urlPath); // 通过地址创建URL对象
		HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // 建立HTTP连接
		conn.connect();
		InputStream is = conn.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String str = null;
		while ((str = br.readLine()) != null) { // 按行读取
			System.out.println(str);
		}
		br.close();
		isr.close();
		is.close();
	}
}