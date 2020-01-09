/**
 * @Title: SocketClient.java
 * @Package cn.osxm.jcodef.func.socket
 * @Description: TODO
 * @author oscarchen
 * @date 2020年1月9日
 * @version V1.0
 */
package cn.osxm.jcodef.func.socket;

import java.io.OutputStream;
import java.net.Socket;

/**
 * @ClassName: SocketClient
 * @Description: TODO
 * @author oscarchen
 */
public class SocketClient {
	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 */

	public static void main(String[] args) throws Exception {
		String host = "localhost";
		int port = 12345; // 服务端的监听端口
		Socket socket = new Socket(host, port);
		OutputStream os = socket.getOutputStream();
		String message = "Hello, Java Socket";
		socket.getOutputStream().write(message.getBytes("UTF-8"));
		os.close();
		socket.close();
	}
}
