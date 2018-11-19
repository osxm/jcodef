/**
 * @Title: Demo.java
 * @Package cn.osxm.jcodef.springcxf.model
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年11月19日 上午7:11:46
 * @version V1.0
 */

package cn.osxm.jcodef.springcxf.model;

/**
 * @ClassName: Demo
 * @Description: TODO
 * @author osxm:oscarxueming
 */

public class Demo {
	private String name;

	private String description;

	public Demo() {

	}

	public Demo(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
