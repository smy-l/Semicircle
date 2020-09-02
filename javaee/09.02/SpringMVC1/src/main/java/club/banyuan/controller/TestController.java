package club.banyuan.controller;

import club.banyuan.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping("/parent")
public class TestController {
    @RequestMapping("/test")
    public String test(@RequestParam(name = "param",required = true,defaultValue = "默认值") String paramName){
        System.out.println("TestController --- test");
        System.out.println(paramName);
        return "result";
    }

//     <a href="parent/test4/value">
    @RequestMapping("/test4/{param}")
    public String test4(@PathVariable("param") String param){
        System.out.println(param);
        return "result";
    }

    @RequestMapping("/test2")
    public String test2(String username, String password, Integer userId, Date birth){
        System.out.println(userId+"   "+username+"   "+password);
        System.out.println(birth);
        return "result";
    }

    @RequestMapping("/test3")
    public String test3(User user){
        System.out.println(user);
        return "result";
    }

    @RequestMapping("/test5")
    public String test5(@CookieValue("JSESSIONID") String cookieValue){
        System.out.println(cookieValue);
        return "result";
    }
}
