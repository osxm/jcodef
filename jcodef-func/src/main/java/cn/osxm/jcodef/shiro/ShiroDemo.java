/**
 * @Title: ShiroDemo.java
 * @Package cn.osxm.jcodef.shiro
 * @Description: TODO
 * @author oscarchen
 * @date 2019年11月6日
 * @version V1.0
 */
package cn.osxm.jcodef.shiro;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
/**
 * @ClassName: ShiroDemo
 * @Description: TODO
 * @author oscarchen
 */
public class ShiroDemo {
	public static void main(String[] args) {

		// 1. 初始化安全管理器SecurityManager
		DefaultSecurityManager securityManager = new DefaultSecurityManager();
		IniRealm iniRealm = new IniRealm("classpath:shiro.ini");
		securityManager.setRealm(iniRealm);
		SecurityUtils.setSecurityManager(securityManager);

		// 2. 获取主体
		Subject currentUser = SecurityUtils.getSubject();

		// 3.用户名/密码验证
		if (!currentUser.isAuthenticated()) {
			System.out.println("开始验证");
			UsernamePasswordToken token = new UsernamePasswordToken("oscar", "123456");
			token.setRememberMe(true);
			try {
				currentUser.login(token);
			} catch (UnknownAccountException uae) {
				System.out.println("用户不存在：" + token.getPrincipal());
			} catch (IncorrectCredentialsException ice) {
				System.out.println("密码错误： " + token.getPrincipal() + " ");
			} catch (LockedAccountException lae) {
				System.out.println("账号被锁了");
			}

			System.out.println("验证成功");
		}

		// 4. 授权判断
		// 4.1 是admin角色
		if (currentUser.hasRole("admin")) {

		}
		// 4.2 有创建用户权限（类层级）
		if (currentUser.isPermitted("user:create")) {

		}
		// 4.3 有删除oscar这个用户的权限（实例层级）
		if (currentUser.isPermitted("user:delete:oscar")) {

		}

		// 5.登出
		currentUser.logout();
	}
}
