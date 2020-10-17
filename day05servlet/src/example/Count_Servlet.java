package example;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * @Author:Aurevoir
 * @Date: 2020/3/22  19:46
 *
 * 网页访问量的统计
 *
 * 分析：因为所有资源被访问都要计算入统计量中，所以必须使用ServletContext保存访问量。
 * 1. 当第一次被访问时，设置变量值为1，并保存至ServletContext中
 * 2. 后续在被访问，在获取变量，将其加1
 */
@WebServlet(name = "Count_Servlet",urlPatterns = "/count")
public class Count_Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = this.getServletContext();
        Integer count = (Integer)application.getAttribute("count");
        if(count==null){
            application.setAttribute("count",1);
        }else{
            application.setAttribute("count",count+1);
        }
//        向浏览器中输出,使用response对象
//        System.out.println(count);
        PrintWriter writer = response.getWriter();
        writer.println("<h1>"+count+"<h1>");
        writer.close();
    }
}
