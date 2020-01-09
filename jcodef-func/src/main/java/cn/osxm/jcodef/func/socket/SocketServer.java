/**
 * @Title: SocketServer.java
 * @Package cn.osxm.jcodef.func.socket
 * @Description: TODO
 * @author oscarchen
 * @date 2020年1月9日
 * @version V1.0
 */
package cn.osxm.jcodef.func.socket;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName: SocketServer
 * @Description: TODO
 * @author oscarchen
 */
public class SocketServer {
	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 * @throws Exception
	 */

	public static void main(String[] args) throws Exception {
		int port = 12345; // 监听端口
		ServerSocket server = new ServerSocket(port);
		System.out.println("Wating Client Connect....");
		Socket socket = server.accept();
		InputStream is = socket.getInputStream();
		byte[] bytes = new byte[1024];
		int len;
		StringBuilder sb = new StringBuilder();
		while ((len = is.read(bytes)) != -1) {
			sb.append(new String(bytes, 0, len, "UTF-8"));
		}
		System.out.println("Message from client: " + sb);
		// 关闭连接
		is.close();
		socket.close();
		server.close();
	}
}
