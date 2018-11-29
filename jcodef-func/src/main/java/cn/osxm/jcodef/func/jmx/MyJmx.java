/**
 * @Title: MyJmx.java
 * @Package cn.osxm.jcodef.func.jmx
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年11月30日 上午5:45:08
 * @version V1.0
 */

package cn.osxm.jcodef.func.jmx;

/**
 * @ClassName: MyJmx
 * @Description: TODO
 * @author osxm:oscarxueming
 */

public class MyJmx implements MyJmxMBean {

	private String name;

	/**
	 * Title: getName Description:
	 * 
	 * @return
	 * @see com.oscar999.jmx.MyJmxMBean#getName()
	 */


	public String getName() {
		// TODO Auto-generated method stub
		System.out.println("Get MyJmx name=" + name);
		return name;
	}

	/**
	 * Title: setName Description:
	 * 
	 * @param name
	 * @see com.oscar999.jmx.MyJmxMBean#setName(java.lang.String)
	 */

	
	public void setName(String name) {
		// TODO Auto-generated method stub
		System.out.println("Set MyJmx name=" + name);
		this.name = name;
	}
}