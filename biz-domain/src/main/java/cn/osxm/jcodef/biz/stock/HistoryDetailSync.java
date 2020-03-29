/**
 * @Title: HistoryDetailSync.java
 * @Package cn.osxm.jcodef.biz.stock
 * @Description: TODO
 * @author oscarchen
 * @date 2020年3月28日
 * @version V1.0
 */
package cn.osxm.jcodef.biz.stock;

/**
  * @ClassName: HistoryDetailSync
  * @Description: TODO
  * @author oscarchen
  */
public class HistoryDetailSync {
	private SessionFactory sessionFactory;
	private Session session = null;
	private Transaction transaction = null;

	@Before
	public void openSessionAndTrans() {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		//transaction = session.beginTransaction();
	}

	@Test
	public void syncHistroyDetails() throws IOException {
		StockMyBaticService service = new StockMyBaticService();
		//List<StockBasic> list = service.getStockBasicList(null);
		List<StockBasic> list = service.getStockBasicList("sz");
		if (list != null && list.size() > 0) {		
			for (int i = 0; i < list.size(); i++) {
				transaction = session.beginTransaction();
				StockBasic stockBasic = list.get(i);
				String fullId = stockBasic.getMarket() + stockBasic.getId();
				syncSingleData(fullId);
				transaction.commit();
			}
			
		}
	}

	/**
	 * 
	 * @Title: syncSingleData
	 * @Description: TODO
	 * @param stockId
	 *            sz300615
	 */
	public void syncSingleData(String stockId) {
		DataInterface dataI = new DataInterface();
		List<StockDetail> list = dataI.getStockDetailList(stockId);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				session.save(list.get(i));
			}
		}
	}

	@After
	public void closeSessionAndTrans() {
		//transaction.commit();
		session.close();
		if (sessionFactory != null)
			sessionFactory.close();
	}
}
