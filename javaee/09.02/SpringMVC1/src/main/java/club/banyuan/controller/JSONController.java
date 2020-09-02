package club.banyuan.controller;

import club.banyuan.pojo.UserAddress;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class JSONController {
    @RequestMapping("/json1")
    @ResponseBody
    public List<UserAddress> json1(String param){
        System.out.println(param);

        UserAddress userAddress1 = new UserAddress();
        userAddress1.setProvince("江苏");
        userAddress1.setCity("NanJing");

        UserAddress userAddress2 = new UserAddress();
        userAddress2.setProvince("江苏");
        userAddress2.setCity("镇江");

        List<UserAddress> userAddressList = new ArrayList<UserAddress>();
        userAddressList.add(userAddress1);
        userAddressList.add(userAddress2);

        return userAddressList;
    }
}
