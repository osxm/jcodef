/**
 * @Title: SqlReg.java
 * @Package cn.osxm.jcodef.func.jdbc
 * @Description: TODO
 * @author oscarchen
 * @date 2020年1月9日
 * @version V1.0
 */
package cn.osxm.jcodef.func.jdbc;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * @ClassName: SqlReg
 * @Description: TODO
 * @author oscarchen
 */
public class SqlReg {
	public String getRegexpInstr(String projectVersion) {
		if (projectVersion != null && projectVersion.length() > 0) {
			String[] projectVersions = null;
			if (projectVersion.indexOf(";") >= 0) {
				projectVersions = projectVersion.split(";");
			} else {
				projectVersions = projectVersion.split(",");
			}
			if (projectVersions != null && projectVersions.length > 0) {
				for (int i = 0; i < projectVersions.length; i++) {
					projectVersions[i] = "(^|\\W)" + projectVersions[i] + "(\\W|$)";
				}
				StringBuffer sb = new StringBuffer();
				sb.append("(")
						.append(String.join("|",
								Arrays.asList(projectVersions).stream().map(String::trim).collect(Collectors.toList())))
						.append(")");
				return sb.toString();
			}
		}
		return null;
	}

	@Test
	public void test() {
		String str = this.getRegexpInstr("A12345A");
		System.out.println(str);
	}
}
