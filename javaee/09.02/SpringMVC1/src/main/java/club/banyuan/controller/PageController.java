package club.banyuan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class PageController {

    @RequestMapping("/result1")
    public String result1(HttpServletRequest request, HttpSession session){
        System.out.println("PageController --- result");
        request.setAttribute("reqAttr","reqValue");
        session.setAttribute("sessionAttr","sessionValue");
        ServletContext application = request.getServletContext();
        application.setAttribute("appAttr","appValue");
        return "result";
    }

    @RequestMapping("/result2")
    public String result2(Model model){
        model.addAttribute("modelAttr","modelValue");
        return "result";
    }

    @RequestMapping("/result3")
    public ModelAndView result3(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("result");
        mv.addObject("modelAttr","modelValue");
//        return "result";
        return mv;
    }

    @RequestMapping("/result4")
    public String result4(){
        System.out.println("PageController --- result");
        return "redirect:result.jsp";
    }


}
