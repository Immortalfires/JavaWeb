import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * @Author:Aurevoir
 * @Date: 2020/4/6  14:58
 *
 * 防盗链：保证超链接来自本站，如果不是，则返回错误码
 * 使用Referer请求头
 */
@WebServlet(name = "J_Servlet",urlPatterns = "/J")
public class J_Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String referer = request.getHeader("Referer");
        System.out.println(referer);
        if(referer == null || !referer.contains("localhost")){
            response.sendRedirect("http://www.bilibili.com");
        }else{
            System.out.println(true);
        }
    }
}
