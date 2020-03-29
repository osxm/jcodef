/**
 * @Title: StockEvaluator.java
 * @Package cn.osxm.jcodef.biz.stock
 * @Description: TODO
 * @author oscarchen
 * @date 2020年3月28日
 * @version V1.0
 */
package cn.osxm.jcodef.biz.stock;

/**
  * @ClassName: StockEvaluator
  * @Description: TODO
  * @author oscarchen
  */
public class StockEvaluator {
	private StockMyBaticService service;
	
	public StockEvaluator(){
		service = new StockMyBaticService();
	}
	

	public EnumAction evaluate(String stockId) {
		//1. bias 
		Map map = biasEvaluate(stockId);
		return (EnumAction) map.get("action");
	}
	
	/**
	 * 
	  * @Title: biasEvaluate
	  * @Description:
	  * 1. bias30 < -16 buy;bias30>16 sell
	  * @param stockId
	  * @return {action: , msg:''}
	 */
	public Map biasEvaluate(String stockId){
		Map map = new HashMap();
		EnumAction action =  EnumAction.NONE;
		BIAS bias = new BIAS(stockId,service);
		float f = bias.getBIAS(30,false);
		float bias1 = bias.getBIAS(6,false);
		float bias2 = bias.getBIAS(12,false);
		float bias3 = bias.getBIAS(24,false);
		
		
		if(f>16) {
			action = EnumAction.SELL;
		//}else if(f<-16 && bias1<-30 && bias2<-20 && bias3<-18) {
		//}else if(f<-16 && bias1<-20 && bias2<-10 && bias3<-10) {
		}else if( bias3<-40) {
			action = EnumAction.BUY;
		}
		map.put("action", action);
		map.put("msg", "bias30 =" +f);
		return map;
	}
}
