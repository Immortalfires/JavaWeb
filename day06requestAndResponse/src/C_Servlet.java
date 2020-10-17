import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * @Author:Aurevoir
 * @Date: 2020/4/4  17:47
 * 重定向至此
 */
@WebServlet(name = "C_Servlet",urlPatterns = "/C")
public class C_Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("C_Servlet访问成功");
    }
}
