/**
 * @Title: StockMyBaticService.java
 * @Package cn.osxm.jcodef.biz.stock.service
 * @Description: TODO
 * @author oscarchen
 * @date 2020年3月28日
 * @version V1.0
 */
package cn.osxm.jcodef.biz.stock.service;

/**
 * @ClassName: StockMyBaticService
 * @Description: TODO
 * @author oscarchen
 */
public class StockMyBaticService {
	private SqlSession openSession;

	public StockMyBaticService() {
		openSession = MyBatisSessionFactory.getSession();
	}

	public List<StockBasic> getStockBasicList(String market) throws IOException {
		List<StockBasic> list = null;
		StockBasicMapper stockMapper = openSession.getMapper(StockBasicMapper.class);
		if (market != null && market.length() > 0) {
			list = (List<StockBasic>) stockMapper.findStrockBasicsByMarket(market);
		} else {
			list = (List<StockBasic>) stockMapper.findStrockBasics();
		}
		return list;
	}

	public List<StockList> getStockIdList() throws IOException {
		List<StockList> list = null;
		try {
			list = openSession.selectList("cn.osxm.jcodef.biz.stock.mapper.StockListMapper.findStrockIds");
		} finally {
			openSession.close();
		}
		return list;
	}

	public List<StockDetail> getStockDetailList(String sfullId) throws IOException {
		List<StockDetail> list = null;
		StockDetailMapper stockMapper = openSession.getMapper(StockDetailMapper.class);
		list = (List<StockDetail>) stockMapper.findStrockDetail(sfullId);
		return list;
	}

	public List<Stock> getStockDateList(String sfullId) throws IOException {
		List<Stock> list = null;
		StockMapper stockMapper = openSession.getMapper(StockMapper.class);
		list = (List<Stock>) stockMapper.findStrockDatas(sfullId);
		return list;
	}
}
