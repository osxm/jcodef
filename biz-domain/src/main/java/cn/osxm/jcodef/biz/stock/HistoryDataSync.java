/**
 * @Title: HistoryDataSync.java
 * @Package cn.osxm.jcodef.biz.stock
 * @Description: TODO
 * @author oscarchen
 * @date 2020年3月28日
 * @version V1.0
 */
package cn.osxm.jcodef.biz.stock;

/**
  * @ClassName: HistoryDataSync
  * @Description: TODO
  * @author oscarchen
  */
public class HistoryDataSync {
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
	public void syncHistroyData() throws IOException {
		StockMyBaticService service = new StockMyBaticService();
		@SuppressWarnings("rawtypes")
		List list = service.getStockIdList();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				StockList stockList = (StockList) list.get(i);
				String fullId = stockList.getMarket() + stockList.getId();
				syncSingleData(fullId);

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
		List<Stock> list = dataI.getStockPriceList(stockId);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				session.save(list.get(i));
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
