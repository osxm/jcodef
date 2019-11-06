/**
 * @Title: JDBCDemo.java
 * @Package cn.osxm.jcodef.func.jdbc
 * @Description: TODO
 * @author oscarchen
 * @date 2019年11月6日
 * @version V1.0
 */
package cn.osxm.jcodef.func.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @ClassName: JDBCDemo
 * @Description: TODO
 * @author oscarchen
 */
public class JDBCDemo {
	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 * @throws Exception
	 */

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:8066/TESTDB?serverTimezone=UTC";
		String driverClassName = "com.mysql.cj.jdbc.Driver";
		Class.forName(driverClassName);
		String username = "root";
		String password = "123456";
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql1 = "insert into my_user(id,country,name) values('001','china','User 1')";
		String sql2 = "insert into my_user(id,country,name) values('002','usa','User 2')";
		String sql3 = "insert into my_user(id,country,name) values('003','england','User 3')";

		PreparedStatement pstmt = conn.prepareStatement(sql1);
		pstmt.execute();

		pstmt.close();
		conn.close();
	}
}
