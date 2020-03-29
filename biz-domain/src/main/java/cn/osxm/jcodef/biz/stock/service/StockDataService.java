/**
 * @Title: StockDataService.java
 * @Package cn.osxm.jcodef.biz.stock.service
 * @Description: TODO
 * @author oscarchen
 * @date 2020年3月28日
 * @version V1.0
 */
package cn.osxm.jcodef.biz.stock.service;

/**
 * @ClassName: StockDataService
 * @Description: TODO
 * @author oscarchen
 */
public class StockDataService {
	private SessionFactory sessionFactory;
	private Session session = null;
	private Transaction transaction = null;

	private void openSessionAndTrans() {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
	}

	private void closeSessionAndTrans() {
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	public List<Stock> getStockList() {
		openSessionAndTrans();
		List<Stock> list = null;
		String hql = "from Stock order by sdate desc";
		Query<Stock> query = session.createQuery(hql);
		list = query.list();
		closeSessionAndTrans();
		return list;
	}

}
