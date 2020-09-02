package club.banyuan.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CustomExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        ModelAndView mv = new ModelAndView();

        if(e instanceof CustomException ){
            mv.addObject("message","这里发生了自定义异常");
        }

        else if (e instanceof NullPointerException){
            mv.addObject("message","这里发生了空指针异常");
        }

        mv.setViewName("error");
        return mv;
    }
}
