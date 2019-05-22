/**
 * @Title: SpiDemo.java
 * @Package cn.osxm.jcodef.func.spi
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2019年5月22日 下午10:08:56
 * @version V1.0
 */

package cn.osxm.jcodef.func.spi;

import java.util.ServiceLoader;
/**
  * @ClassName: SpiDemo
  * @Description: TODO
  * @author osxm:oscarxueming
  */

public class SpiDemo {
	public static void main(String[] args) {
        ServiceLoader<SpiHelloWorld> loaders = ServiceLoader.load(SpiHelloWorld.class);
        for (SpiHelloWorld spiHelloWorld : loaders) {
            spiHelloWorld.hello();
        }
    }
}
