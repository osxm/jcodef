/**
 * @Title: MyBatisSessionFactory.java
 * @Package cn.osxm.jcodef.biz.stock.service
 * @Description: TODO
 * @author oscarchen
 * @date 2020年3月28日
 * @version V1.0
 */
package cn.osxm.jcodef.biz.stock.service;

/**
 * @ClassName: MyBatisSessionFactory
 * @Description: TODO
 * @author oscarchen
 */
public class MyBatisSessionFactory {
	private static SqlSession openSession;

	public static void openSession() {
		SqlSessionFactory sqlSessionFactory = initSQLSessionFactory();
		openSession = sqlSessionFactory.openSession();
	}

	public static SqlSession getSession() {
		if (openSession == null) {
			openSession();
		}
		return openSession;
	}

	public static void closeSession() {
		if (openSession != null) {
			openSession.close();
		}
	}

	private static SqlSessionFactory initSQLSessionFactory() {
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
}
