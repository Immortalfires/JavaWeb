package test5;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * 从ServletContext中获取数据
 *  @Author:Aurevoir
 * @Date: 2020/3/22  15:16
 */
@WebServlet(name = "H_Servlet",urlPatterns = "/H")
public class H_Servlet extends HttpServlet {
    /**
     * 1. 获取ServletContext对象
     * 2. 调用getAttribute获取数据
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = this.getServletContext();
        String name = (String)application.getAttribute("name");
        System.out.println(name);
    }
}
