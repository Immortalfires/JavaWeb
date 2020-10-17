import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * @Author:Aurevoir
 * @Date: 2020/4/4  17:45
 * 模拟重定向
 * 用户请求B，B返回302，给出Location，
 */
@WebServlet(name = "B_Servlet",urlPatterns = "/B")
public class B_Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("B_Servlet");
         /*
        设置Location，发送302
        */
         //值为 项目名+servlet路径，统称为请求URL
         response.setHeader("Location","/day06requestAndResponse/C");
         response.setStatus(302);
    }
}
