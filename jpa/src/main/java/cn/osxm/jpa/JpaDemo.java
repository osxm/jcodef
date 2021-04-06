/**
 * @Title: JpaDemo.java
 * @Package cn.osxm.jpa
 * @Description: TODO
 * @author oscarchen
 * @date 2021年4月7日
 * @version V1.0
 */
package cn.osxm.jpa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import cn.osxm.jpa.entity.User;


/**
  * @ClassName: JpaDemo
  * @Description: TODO
  * @author oscarchen
  */
public class JpaDemo {

	private Connection conn;

	private Statement stmt;
	
	public void initH2Database() throws Exception {
		String JDBC_URL = "jdbc:h2:mem:myh2";
		String USER = "root";
		String PASSWORD = "123456";
		String DRIVER_CLASS = "org.h2.Driver";
		Class.forName(DRIVER_CLASS);
		conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
		stmt = conn.createStatement();
		stmt.execute("DROP TABLE IF EXISTS USER");
		stmt.execute("CREATE TABLE USER(id VARCHAR(10) PRIMARY KEY,name VARCHAR(50))");
		stmt.executeUpdate("INSERT INTO USER VALUES('001','刘备')");
		stmt.executeUpdate("INSERT INTO USER VALUES('002','关羽')");
		stmt.executeUpdate("INSERT INTO USER VALUES('003','张飞')");	
		
	}
	
	public void close() throws Exception {
		stmt.close();
		conn.close();
	}
	
	public void jpaQuery() {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("my_h2");
		EntityManager em = emFactory.createEntityManager();
		List<User> list  = em.createQuery("select u from User u",User.class).getResultList();
		for(User user:list) {
			System.out.println(user.toString());
		}
		//CriteriaBuilder cb = em.getCriteriaBuilder();
		//CriteriaQuery(User) cq = cb.cr
		
		
	}
	
	public static void main(String[] args) throws Exception {
		JpaDemo jpaDemo= new JpaDemo();
		jpaDemo.initH2Database();
		jpaDemo.jpaQuery();
	}

}
