package test5;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/*
 * @Author:Aurevoir
 * @Date: 2020/3/22  19:59
 *
 * 获取类路径下的资源
 */
@WebServlet(name = "K_Servlet",urlPatterns = "/K")
public class K_Servlet extends HttpServlet {
    /**
     * 1. 得到ClassLoader
     * 2. 调用getResourcesAsStream()，得到InputStream
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        相对于classes目录写路径
//        ClassLoader classLoader = this.getClass().getClassLoader();
//        InputStream inputStream = classLoader.getResourceAsStream("a.txt");
//        相对于当前.class文件所在的目录
        Class c = this.getClass();
        InputStream inputStream = c.getResourceAsStream("a.txt");
        String str = null;
        if (inputStream != null) {
            str = IOUtils.toString(inputStream);
        }
        System.out.println(str);
    }
}
