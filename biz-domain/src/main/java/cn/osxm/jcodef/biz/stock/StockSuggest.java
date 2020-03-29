/**
 * @Title: StockSuggest.java
 * @Package cn.osxm.jcodef.biz.stock
 * @Description: TODO
 * @author oscarchen
 * @date 2020年3月28日
 * @version V1.0
 */
package cn.osxm.jcodef.biz.stock;

/**
  * @ClassName: StockSuggest
  * @Description: TODO
  * @author oscarchen
  */
public class StockSuggest {
	@Test
	public void select() {
		
		MyBatisSessionFactory.openSession();
		List<StockBasic> buyList = new ArrayList<StockBasic>();
		List<StockBasic> sellList = new ArrayList<StockBasic>();
		StockMyBaticService mybatisService = new StockMyBaticService();
		StockEvaluator evaluator = new StockEvaluator();
		List<StockBasic> list = null;
		try {
			list = mybatisService.getStockBasicList(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list!=null)
		{
			int iTotal = list.size();
			for(int i=0;i<iTotal;i++)
			{				
				StockBasic stockBasic = list.get(i);
				System.out.println("do  "+ stockBasic.getId());
				String fullId = stockBasic.getMarket()+stockBasic.getId();
				EnumAction action = evaluator.evaluate(fullId);
				if(action.equals(EnumAction.BUY)) {
					buyList.add(stockBasic);
				}else if(action.equals(EnumAction.SELL)) {
					sellList.add(stockBasic);
				}			
			}
		}	
		MyBatisSessionFactory.closeSession();
		
		System.out.println("Begin Buy List:");
		for(int i=0;i<buyList.size();i++) {
			System.out.println(buyList.get(i).getId()+" "+buyList.get(i).getName());
		}
		System.out.println("End Buy List:");
		
		System.out.println("Begin Sell List:");
		for(int i=0;i<sellList.size();i++) {
			System.out.println(sellList.get(i).getId()+" "+sellList.get(i).getName());
		}
		System.out.println("End Sell List:");
		
	
	}
}
