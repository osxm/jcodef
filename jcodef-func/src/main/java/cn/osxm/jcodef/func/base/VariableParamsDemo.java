/**
 * @Title: VariableParamsDemo.java
 * @Package cn.osxm.jcodef.func.base
 * @Description: TODO
 * @author oscarchen
 * @date 2020年2月7日
 * @version V1.0
 */
package cn.osxm.jcodef.func.base;

/**
  * @ClassName: VariableParamsDemo
  * @Description: TODO
  * @author oscarchen
  */
public class VariableParamsDemo {

	public static int sum(int ...iArray) {
		int iTotal = 0;
		for(int i:iArray) {
			iTotal += i;
		}
		return iTotal;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int iTotal = sum(1,1);
		System.out.println(iTotal);
	}

}
