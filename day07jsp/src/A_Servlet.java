import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * @Author:Aurevoir
 * @Date: 2020/4/14  16:49
 */
@WebServlet(name = "A_Servlet",urlPatterns = "/A")
public class A_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String s1 = request.getParameter("a");
        String s2 = request.getParameter("b");
        //转换成int
        int num1 = Integer.parseInt(s1);
        int num2 = Integer.parseInt(s2);
        String result = String.valueOf(num1+num2);
        //保存res到request域中
        request.setAttribute("result",result);
        //转发到result.jsp
        request.getRequestDispatcher("/jsps/result.jsp").forward(request,response);
    }
}
