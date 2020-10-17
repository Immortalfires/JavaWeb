import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * @Author:Aurevoir
 * @Date: 2020/4/4  17:59
 * 定时刷新，可以理解为定时重定向
 * 设置Refresh，表示定时刷新
 */
@WebServlet(name = "D_Servlet",urlPatterns = "/D")
public class D_Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        发送响应体
         */
        PrintWriter writer = response.getWriter();
        writer.print("jump to home in 5 seconds,哈哈哈哈");
        /*
        设置Refresh响应头
         */
        response.setHeader("Refresh","5;URL=/day06requestAndResponse/E");
    }
}