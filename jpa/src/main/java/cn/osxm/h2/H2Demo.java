/**
 * @Title: H2Demo.java
 * @Package cn.osxm.h2
 * @Description: TODO
 * @author oscarchen
 * @date 2021年3月31日
 * @version V1.0
 */
package cn.osxm.h2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @ClassName: H2Demo
 * @Description: TODO
 * @author oscarchen
 */
public class H2Demo {
	// 数据库连接URL; mem 内存数据库， myh2 数据库的名字。
	private static final String JDBC_URL = "jdbc:h2:mem:myh2";
	// 连接数据库用户名
	private static final String USER = "root";
	// 连接数据库密码
	private static final String PASSWORD = "123456";
	// 连接H2数据库的驱动
	private static final String DRIVER_CLASS = "org.h2.Driver";

	private Connection conn;

	private Statement stmt;

	// 1. 建立数据库连接
	public void connection() throws Exception {
		Class.forName(DRIVER_CLASS);
		conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
	}

	// 2. 从连接创建语句对象
	public void statement() throws Exception {
		stmt = conn.createStatement();
	}

	// 3. 创建数据库表（先删除，再创建）
	public void createTable() throws Exception {
		stmt.execute("DROP TABLE IF EXISTS MY_H2TABLE");
		stmt.execute("CREATE TABLE MY_H2TABLE(id VARCHAR(10) PRIMARY KEY,name VARCHAR(50))");
	}

	// 4. 插入
	public void insertData() throws Exception {
		stmt.executeUpdate("INSERT INTO MY_H2TABLE VALUES('001','刘备')");
		stmt.executeUpdate("INSERT INTO MY_H2TABLE VALUES('002','关羽')");
		stmt.executeUpdate("INSERT INTO MY_H2TABLE VALUES('003','张飞')");
	}

	// 5.查询
	public void queryData() throws Exception {
		ResultSet rs = stmt.executeQuery("SELECT * FROM MY_H2TABLE");
		while (rs.next()) {
			System.out.println(rs.getString("id") + "," + rs.getString("name"));
		}
	}

	// 6.释放连接
	public void close() throws Exception {
		stmt.close();
		conn.close();
	}

	public static void main(String[] args) throws Exception {
		H2Demo h2 = new H2Demo();
		h2.connection();
		h2.statement();
		h2.createTable();
		h2.insertData();
		h2.queryData();
	}
}
