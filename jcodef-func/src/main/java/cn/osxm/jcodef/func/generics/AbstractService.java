/**
 * @Title: AbstractService.java
 * @Package cn.osxm.jcodef.func.generics
 * @Description: TODO
 * @author oscarchen
 * @date 2019年9月19日
 * @version V1.0
 */
package cn.osxm.jcodef.func.generics;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @ClassName: AbstractService
 * @Description: TODO
 * @author oscarchen
 */
public abstract class AbstractService<T> {

	@SuppressWarnings("unchecked")
	public Class<Object> getActualClass() {
		// Class<T> tClass = (Class<T>) ((ParameterizedType)
		// getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		Class<Object> actualClass = null;
		Type genType = getClass().getGenericSuperclass();
		if (!(genType instanceof ParameterizedType)) {
			actualClass = Object.class;
		} else {
			ParameterizedType pt = (ParameterizedType) genType;
			actualClass = (Class<Object>) pt.getActualTypeArguments()[0];
		}
		return actualClass;
	}
}
