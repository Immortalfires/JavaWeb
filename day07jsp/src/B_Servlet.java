import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
 * @Author:Aurevoir
 * @Date: 2020/4/18  19:45
 */
@WebServlet(name = "B_Servlet",urlPatterns = "/B")
public class B_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    /*
        1. 获取表单数据
     */
        String username = request.getParameter("username");
        String password = request.getParameter("password");

    /*
        2. 校验用户名密码是否正确
     */
        if(!"admin".equalsIgnoreCase(username)){
            //登录成功则保存用户信息至Session，重定向succ1.jsp
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            session.setAttribute("password",password);
            //重定向
            response.sendRedirect("/day07/session2/succ1.jsp");
        }else{
            //登陆失败 保存错误信息至request，转发至login.jsp
            request.setAttribute("msg","用户名或密码错误");
           request.getRequestDispatcher("/session2/login.jsp").forward(request,response);
        }
    }
}
