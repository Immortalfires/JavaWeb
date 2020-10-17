import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * @Author:Aurevoir
 * @Date: 2020/4/4  17:09
 * 演示发送状态码
 */
@WebServlet(name = "A_Servlet",urlPatterns = "/A")
public class A_Servlet extends HttpServlet {
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(404,"资源有误");
    }
}
