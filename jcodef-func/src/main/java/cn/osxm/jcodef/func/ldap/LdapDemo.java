/**
 * @Title: LdapDemo.java
 * @Package cn.osxm.jcodef.func.ldap
 * @Description: TODO
 * @author oscarchen
 * @date 2020年9月28日
 * @version V1.0
 */
package cn.osxm.jcodef.func.ldap;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

/**
 * @ClassName: LdapDemo
 * @Description: TODO
 * @author oscarchen
 */
public class LdapDemo {

	public static void main(String[] args) {

		String principal = "Manager";
		String password = "secret";
		String ldapUrl = "ldap://LAPTOP-C6T2C3A5:389";
		LdapContext ctx = null;
		String searchBase = "dc=maxcrc,dc=com";
		String searchDn = "cn=Manager,dc=maxcrc,dc=com";

		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");// Factory用于创建InitialContext对象
		env.put(Context.SECURITY_AUTHENTICATION, "Simple");
		//env.put(Context.SECURITY_PRINCIPAL, principal);
		env.put(Context.SECURITY_CREDENTIALS, password);
		env.put(Context.SECURITY_PRINCIPAL, searchDn);
		env.put(Context.PROVIDER_URL, ldapUrl);

		SearchControls constraints = new SearchControls();
		constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
		constraints.setReturningAttributes(new String[] { "xxx" });

		try {
			ctx = new InitialLdapContext(env, null);
			NamingEnumeration<SearchResult> results = ctx.search(searchBase, "uid=Oscar", constraints);
			while (results.hasMore()) {
				NameClassPair nc = (NameClassPair) results.next();
				System.out.println(nc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 4.0 close Connection
		finally {
			if (ctx != null) {
				try {
					ctx.close();
					// LOG.info("Close Ldap Successful.");
				} catch (NamingException e) {
					// LOG.error("Exception in ldapClose(): ", e);
				}
			}
		}
	}
}
