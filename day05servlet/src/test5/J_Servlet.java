package test5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

/*
 *  用ServletContext获取资源路径
 * @Author:Aurevoir
 * @Date: 2020/3/22  18:20
 */
@WebServlet(name = "J_Servlet",urlPatterns = "/J")
public class J_Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        1. 先获取ServletContext
        2.调用getRealPath 带盘符的路径
         */
        String path = this.getServletContext().getRealPath("/index.jsp");
        System.out.println(path);

        /*
        调用getResourceAsStream获取资源流
         */
//        InputStream inputStream = new FileInputStream(path);
        InputStream inputStream = this.getServletContext().getResourceAsStream("/index.jsp");
        /*
        获取指定目录下所有资源路径
         */
        Set<String> set = this.getServletContext().getResourcePaths("/WEB-INF");
        System.out.println(set);
    }
}
