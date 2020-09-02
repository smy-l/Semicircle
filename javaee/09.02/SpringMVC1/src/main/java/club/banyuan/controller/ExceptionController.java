package club.banyuan.controller;

import club.banyuan.exception.CustomException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {
    @RequestMapping("/exception")
    public String testEx() throws Exception {
        throw new NullPointerException();
        //throw new CustomException("自定义异常");
    }
}
