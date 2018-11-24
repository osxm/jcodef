package cn.osxm.jcodef.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class HelloWorld
 */
@Stateless
@LocalBean
public class HelloWorld implements HelloWorldRemote {

    /**
     * Default constructor. 
     */
    public HelloWorld() {
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public String sayHello(String username) {
		return "Hello," + username + ". This is first EJB Service.";
	}

}
