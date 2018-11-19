/**
 * @Title: DemoRestWsService.java
 * @Package cn.osxm.jcodef.springcxf.client
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年11月19日 下午10:44:16
 * @version V1.0
 */

package cn.osxm.jcodef.springcxf.client;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
  * @ClassName: DemoRestWsService
  * @Description: TODO
  * @author osxm:oscarxueming
  */

@Path("/message")
@Produces("application/json")
public interface DemoRestWsService {
    
    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/run")
    public String run();
}