/**
 * @Title: SessionDemo.java
 * @Package cn.osxm.jcodef.shiro
 * @Description: TODO
 * @author oscarchen
 * @date 2019年11月6日
 * @version V1.0
 */
package cn.osxm.jcodef.shiro;
import java.util.Date;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
/**
 * @ClassName: SessionDemo
 * @Description: TODO
 * @author oscarchen
 */
public class SessionDemo {
	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 */

	public static void main(String[] args) {
		// 1. 初始化安全管理器SecurityManager
		DefaultSecurityManager securityManager = new DefaultSecurityManager();
		IniRealm iniRealm = new IniRealm("classpath:shiro.ini");
		securityManager.setRealm(iniRealm);
		SecurityUtils.setSecurityManager(securityManager);

		// 2. 获取主体
		Subject currentUser = SecurityUtils.getSubject();

		// 3. 认证
		UsernamePasswordToken token = new UsernamePasswordToken("oscar", "123456");
		currentUser.login(token);

		// 4. 获取会话
		Session session = currentUser.getSession();
		session.setAttribute("mykey", "myvalue"); // 设置会话属性
		Date date = session.getLastAccessTime(); // 获取上次访问时间
	}
}
