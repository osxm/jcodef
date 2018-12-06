package cn.osxm.jcodef.func.aop.base;
public class HelloServiceImpl implements HelloService {

	public String sayHello() {
		System.out.println("Hello world, AOP!");
		return null;
	}

}
