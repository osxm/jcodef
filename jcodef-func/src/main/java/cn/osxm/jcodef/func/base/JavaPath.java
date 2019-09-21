/**
 * @Title: JavaPath.java
 * @Package cn.osxm.jcodef.func.base
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年11月8日 下午8:32:14
 * @version V1.0
 */

package cn.osxm.jcodef.func.base;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName: JavaPath
 * @Description: TODO
 * @author osxm:oscarxueming
 */

public class JavaPath {
	/**
	 * .类的根路径
	 * 
	 * @Title: getClassRootPath
	 * @Description: TODO
	 * @return
	 */
	public String getClassRootPath() {
		String path = this.getClass().getResource("/").getPath();
		return path;
	}

	/**
	 * 类的当前路径， 包括包的路径
	 * 
	 * @Title: getClassPath
	 * @Description: TODO
	 * @return
	 */
	public String getClassPath() {
		String path = this.getClass().getResource("").getPath();
		return path;
	}

	/**
	 * 項目路徑
	 * @return
	 */
	public String getProjectPath() {
		File file = new File("");
		String path = "";
		try {
			path = file.getCanonicalPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	};

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 */

	public static void main(String[] args) {
		JavaPath javaPath = new JavaPath();
		System.out.println("类的根路径" + javaPath.getClassRootPath());
		System.out.println("类的当前路径" + javaPath.getClassPath());
		System.out.println("当前项目路径" + javaPath.getProjectPath());
	}
}
