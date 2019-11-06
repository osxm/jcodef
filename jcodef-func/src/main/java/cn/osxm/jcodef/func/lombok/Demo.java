/**
 * @Title: Demo.java
 * @Package cn.osxm.jcodef.func.lombok
 * @Description: TODO
 * @author oscarchen
 * @date 2019年11月6日
 * @version V1.0
 */
package cn.osxm.jcodef.func.lombok;

import lombok.Builder;
import lombok.ToString;

/**
 * @ClassName: Demo
 * @Description: TODO
 * @author oscarchen
 */
@Builder
@ToString
public class Demo {
	private String id;

	private String name;

}
