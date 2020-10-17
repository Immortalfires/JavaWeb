package servletInclude;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * @Author:Aurevoir
 * @Date: 2020/4/11  19:50
 *
 * 请求包含O_Servlet
 */
@WebServlet(name = "N_Servlet",urlPatterns = "/N")
public class N_Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("N_Servlet");
        //设置响应头
        response.setHeader("aaa","AAA");
        //设置响应体
        //留头又留体
        response.getWriter().write("N_Servlet");

        request.getRequestDispatcher("/O").include(request,response);
    }
}
