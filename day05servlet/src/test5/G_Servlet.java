package test5;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * 向ServletContext中保存数据
 * @Author:Aurevoir
 * @Date: 2020/3/22  15:10
 */
@WebServlet(name = "G_Servlet",urlPatterns = "/G")
public class G_Servlet extends HttpServlet {
    /**
     * 1. 获取ServletContext对象
     * 2. 调用setAttribute保存对象
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = this.getServletContext();
        application.setAttribute("name","myData");
    }
}
