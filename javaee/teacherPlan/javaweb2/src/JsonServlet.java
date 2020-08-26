import club.banyuan.User;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "JsonServlet",urlPatterns = "/json.do")
public class JsonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setId(1);
        user.setLoginName("aaa");
        user.setUserName("ccc");
        user.setEmail("sdfsdf@sd.com");
        user.setIdentityCode("3223243424");
        user.setMobile("sdfsdfs");
        user.setPassword("234234");
        user.setSex(1);
        user.setType(1);

        String jsonUser = JSON.toJSONString(user);
        System.out.println(jsonUser);

        User user2 = new User();
        user2.setId(2);
        user2.setLoginName("XXX");
        user2.setUserName("sdfsdf");
        user2.setEmail("sdffsdf@sd.com");
        user2.setIdentityCode("45345");
        user2.setMobile("gdf");
        user2.setPassword("23423424234");
        user2.setSex(0);
        user2.setType(2);

        List<User> userList = new ArrayList<User>();
        userList.add(user);
        userList.add(user2);

        String jsonArray = JSON.toJSONString(userList);
        System.out.println(jsonArray);

        PrintWriter out = response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
