/**
 * @Title: H2Demo.java
 * @Package cn.osxm.h2
 * @Description: TODO
 * @author oscarchen
 * @date 2021��3��31��
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
	// ���ݿ�����URL; mem �ڴ����ݿ⣬ myh2 ���ݿ�����֡�
	private static final String JDBC_URL = "jdbc:h2:mem:myh2";
	// �������ݿ��û���
	private static final String USER = "root";
	// �������ݿ�����
	private static final String PASSWORD = "123456";
	// ����H2���ݿ������
	private static final String DRIVER_CLASS = "org.h2.Driver";

	private Connection conn;

	private Statement stmt;

	// 1. �������ݿ�����
	public void connection() throws Exception {
		Class.forName(DRIVER_CLASS);
		conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
	}

	// 2. �����Ӵ���������
	public void statement() throws Exception {
		stmt = conn.createStatement();
	}

	// 3. �������ݿ����ɾ�����ٴ�����
	public void createTable() throws Exception {
		stmt.execute("DROP TABLE IF EXISTS MY_H2TABLE");
		stmt.execute("CREATE TABLE MY_H2TABLE(id VARCHAR(10) PRIMARY KEY,name VARCHAR(50))");
	}

	// 4. ����
	public void insertData() throws Exception {
		stmt.executeUpdate("INSERT INTO MY_H2TABLE VALUES('001','����')");
		stmt.executeUpdate("INSERT INTO MY_H2TABLE VALUES('002','����')");
		stmt.executeUpdate("INSERT INTO MY_H2TABLE VALUES('003','�ŷ�')");
	}

	// 5.��ѯ
	public void queryData() throws Exception {
		ResultSet rs = stmt.executeQuery("SELECT * FROM MY_H2TABLE");
		while (rs.next()) {
			System.out.println(rs.getString("id") + "," + rs.getString("name"));
		}
	}

	// 6.�ͷ�����
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
