package servletForward;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * @Author:Aurevoir
 * @Date: 2020/4/11  19:13
 *
 * 将L_Servlet的请求转发至M_Servlet
 */
@WebServlet(name = "L_Servlet",urlPatterns = "/L")
public class L_Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("L_Servlet");
        //设置响应头
        response.setHeader("aaa","AAA");
        //设置响应体
        //留头不留体

        request.setAttribute("username","happy");
        request.setAttribute("password","xxxx");
        response.getWriter().write("L_Servlet");

        request.getRequestDispatcher("/M").forward(request,response);


    }
}
