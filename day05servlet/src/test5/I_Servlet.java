package test5;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 *ServletContext获取公共初始化参数
 *  @Author:Aurevoir
 * @Date: 2020/3/22  16:37
 */
@WebServlet(name = "I_Servlet",urlPatterns = "/I")
public class I_Servlet extends HttpServlet {
    /**
     * 1. 得到ServletContext
     * 2. 调用getInitParameter
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = this.getServletContext();
        String param = application.getInitParameter("context-param");
        System.out.println(param);
    }
}
