import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * @Author:Aurevoir
 * @Date: 2020/4/6  14:46
 */
@WebServlet(name = "I_Servlet",urlPatterns = "/I")
public class I_Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("请求协议："+request.getScheme());
        System.out.println("服务器名："+request.getServerName());
        System.out.println("服务器端口号："+request.getServerPort());
        System.out.println("项目名："+request.getContextPath());
        System.out.println("Servlet路径："+request.getServletPath());
        System.out.println("参数部分："+request.getQueryString());
        System.out.println("URI,项目名+Servlet路径："+request.getRequestURI());
        System.out.println("URL,不包含参数的整个路径："+request.getRequestURL());
    }
}
