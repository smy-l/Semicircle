package club.banyuan.aspect;

import club.banyuan.common.Constant;
import club.banyuan.common.ServerException;
import club.banyuan.log.entity.Log;
import club.banyuan.log.srevice.LogService;
import club.banyuan.user.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class ControllerAspect {

  /**
   * 记录所有被LogAspect标记的方法的入参和返回值
   * 记录请求controller的 url，用户名，contoller方法的执行时间
   */
  @Autowired
  private LogService logService;

  /**
   * 切入点，定义了生成代理对象的方法
   */
  @Pointcut("@annotation(club.banyuan.aspect.LogAspect)")
  public void controllerLog() {
  }

  @Around("controllerLog()")
  public Object around(ProceedingJoinPoint pjp) throws JsonProcessingException {
    RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();

    HttpSession session = request.getSession();
    User user = (User) session.getAttribute(Constant.USER_SESSION);
    if (user == null) {
      throw new ServerException("记录信息失败，没有用户登录信息");
    }

    Log log = new Log();
    String servletPath = request.getServletPath();
    // 记录发起请求的计算机的ip地址
    String ip = request.getRemoteHost();

    log.setUrl(servletPath);
    log.setIp(ip);
    // 从session中获取用户名
    log.setOperator(user.getName());

    // 需要判断参数列表中具有LogAspect参数的一系列参数，这些参数需要保存到数据库中
    // 因此需要将这些参数筛选出来

    // 获取到切入点方法的参数列表
    Object[] args = pjp.getArgs();

    // 定义最终被筛选出来的集合，key 为参数名
    Map<String, Object> recordMap = new HashMap<>();

    // 通过连接点的对象，获取到方法对象，进行类型转换为了获取到参数的注解列表
    MethodSignature signature = (MethodSignature) pjp.getSignature();

    // 获取所有的方法参数的名称列表，作为map的key，这些参数中有的带有LogAspect注解，有的没有
    // 需要进行过滤
    String[] parameters = signature.getParameterNames();

    // 获取到被调用的方法的 参数注解列表，是一个二维数据，每个参数都有可能有多个注解
    Annotation[][] parameterAnnotations = signature.getMethod().getParameterAnnotations();
    for (int i = 0; i < parameterAnnotations.length; i++) {
      // 第一个维度，表示取其中一个参数，参数下面有多个注解，因此需要在进行遍历，
      // 其中只要有注解满足是LogAspect，这个参数就需要被放到最终过滤结果中
      // 满足条件的位置i，刚好和上面参数名称的数组的i一致
      for (Annotation annotation : parameterAnnotations[i]) {
        if(annotation instanceof LogAspect) {
          recordMap.put(parameters[i], args[i]);
          break;
        }
      }
    }

    // jackson的json序列化的方式
    ObjectMapper mapper = new ObjectMapper();

    // 将请求的参数序列化保存
    log.setRequest(mapper.writeValueAsString(recordMap));


  }



}
