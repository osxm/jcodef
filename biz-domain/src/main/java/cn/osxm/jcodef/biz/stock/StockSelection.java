/**
 * @Title: StockSelection.java
 * @Package cn.osxm.jcodef.biz.stock
 * @Description: TODO
 * @author oscarchen
 * @date 2020年3月28日
 * @version V1.0
 */
package cn.osxm.jcodef.biz.stock;

/**
  * @ClassName: StockSelection
  * @Description: TODO
  * @author oscarchen
  */
public class StockSelection {
	@Test
	public void select() {
		List<StockList> buyList = new ArrayList<StockList>();
		List<StockList> sellList = new ArrayList<StockList>();
		StockMyBaticService mybatisService = new StockMyBaticService();
		StockEvaluator evaluator = new StockEvaluator();
		List<StockList> list = null;
		try {
			list = mybatisService.getStockIdList();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list!=null)
		{
			int iTotal = list.size();
			for(int i=0;i<list.size();i++)
			{
				StockList stockIdlist = list.get(i);
				String fullId = stockIdlist.getMarket()+stockIdlist.getId();
				EnumAction action = evaluator.evaluate(fullId);
				if(action.equals(EnumAction.BUY)) {
					buyList.add(stockIdlist);
				}else if(action.equals(EnumAction.SELL)) {
					buyList.add(stockIdlist);
				}			
			}
		}
		
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
