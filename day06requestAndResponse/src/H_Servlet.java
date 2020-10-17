import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * @Author:Aurevoir
 * @Date: 2020/4/6  14:00
 *
 *  获取客户端IP,请求方式，User-Agent，得到客户端信息
 */
@WebServlet(name = "H_Servlet",urlPatterns = "/H")
public class H_Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String IP = request.getRemoteAddr();
        String method = request.getMethod();
        System.out.println("IP地址："+IP + "\t请求方法：" + method);
        String userAgent = request.getHeader("User-Agent");
        System.out.println(userAgent);
        if(userAgent.toLowerCase().contains("chrome")){
            System.out.println("Chrome");
        }else if(userAgent.toLowerCase().contains("edge")){
            System.out.println("IE");
        }
    }
}
