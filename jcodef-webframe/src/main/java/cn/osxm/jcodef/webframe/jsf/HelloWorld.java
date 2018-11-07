/**
 * @Title: HelloWorld.java
 * @Package cn.osxm.jcodef.webframe.jsf
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年11月8日 上午6:48:42
 * @version V1.0
 */

package cn.osxm.jcodef.webframe.jsf;

import javax.faces.bean.ManagedBean;

/**
 * @ClassName: HelloWorld
 * @Description: TODO
 * @author osxm:oscarxueming
 */

@ManagedBean
public class HelloWorld implements java.io.Serializable {
	private static final long serialVersionUID = 2670923978809388476L;
	private String name;

	public String getName() {
		if (this.name == null) {
			return "Hello World";
		}
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
