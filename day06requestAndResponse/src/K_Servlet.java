import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

/*
 * @Author:Aurevoir
 * @Date: 2020/4/6  15:38
 */
@WebServlet(name = "K_Servlet",urlPatterns = "/K")
public class K_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String[] hobby = request.getParameterValues("hobby");
        System.out.println(username + "\n" + password + "\n" + Arrays.toString(hobby));
        System.out.println("---------------------------------------------------------");
        Enumeration<String> nums = request.getParameterNames();
        while(nums.hasMoreElements()){
            System.out.println(nums.nextElement());
        }
        System.out.println("---------------------------------------------------------");
        Map<String,String[]> map = request.getParameterMap();
        for(String s : map.keySet()){
            String[] value = request.getParameterValues(s);
            System.out.println(s + "=" + Arrays.toString(value));
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("GET:" +request.getParameter("xxx"));
        System.out.println("GET:" +request.getParameter("yyy"));
    }
}
