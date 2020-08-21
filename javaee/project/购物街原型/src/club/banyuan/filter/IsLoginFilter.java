package club.banyuan.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "IsLoginFilter", urlPatterns = "")
public class IsLoginFilter implements Filter {
  public void destroy() {
  }

  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
    HttpServletRequest request = (HttpServletRequest) req;
    HttpSession session = request.getSession();
    Object object = session.getAttribute("user");
    if (object != null) {
      chain.doFilter(req, resp);
    } else {
      req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
  }

  public void init(FilterConfig config) throws ServletException {

  }

}
