import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * @Author:Aurevoir
 * @Date: 2020/4/4  18:06
 * 禁用浏览器缓存
 */
@WebServlet(name = "F_Servlet",urlPatterns = "/F")
public class F_Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("pragma","no-cache");
        response.setDateHeader("expires",-1);
        response.getWriter().println("hello");
    }
}
