/**
 * @Title: CurrentDetailSync.java
 * @Package cn.osxm.jcodef.biz.stock
 * @Description: TODO
 * @author oscarchen
 * @date 2020年3月28日
 * @version V1.0
 */
package cn.osxm.jcodef.biz.stock;

/**
  * @ClassName: CurrentDetailSync
  * @Description: TODO
  * @author oscarchen
  */
public class CurrentDetailSync {
	private SessionFactory sessionFactory;
	private Session session = null;
	private Transaction transaction = null;

	@Before
	public void openSessionAndTrans() {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
	}

	@Test
	public void syncCurrentData() throws IOException {
		StockMyBaticService service = new StockMyBaticService();
		DataInterface dataI = new DataInterface();
		@SuppressWarnings("rawtypes")
		List list = service.getStockBasicList(null);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {			    
				StockBasic stockBasic = (StockBasic) list.get(i);
				String fullId = stockBasic.getMarket() + stockBasic.getId();
				System.out.println(fullId);
				StockDetail stockDetail = dataI.getSingleCurrentDay(fullId);
				session.save(stockDetail);
			}
		}
	}

	@After
	public void closeSessionAndTrans() {
		transaction.commit();
		session.close();
		if (sessionFactory != null)
			sessionFactory.close();
	}
}
