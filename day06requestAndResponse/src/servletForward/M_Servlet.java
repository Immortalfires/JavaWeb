package servletForward;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * @Author:Aurevoir
 * @Date: 2020/4/11  19:14
 */
@WebServlet(name = "M_Servlet",urlPatterns = "/M")
public class M_Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("M_Servlet");

        response.getWriter().write(request.getAttribute("username") + ":" + request.getAttribute("password"));
    }
}
