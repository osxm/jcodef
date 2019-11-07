/**
 * @Title: HomeController.java
 * @Package com.osxm.springboot.controller
 * @Description: TODO
 * @author oscarchen
 * @date 2019年11月7日
 * @version V1.0
 */
package com.osxm.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
  * @ClassName: HomeController
  * @Description: TODO
  * @author oscarchen
  */
@Controller
public class HomeController {

    @RequestMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("msg", "This is Index Page.");
        return "index";
    }

    @RequestMapping("/login")
    public String login(ModelMap map) {
        return "login";
    }
}
