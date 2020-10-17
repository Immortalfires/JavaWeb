package test1;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author:Aurevoir
 * @date: 2020/2/22  12:47
 */
public class A_Servlet implements Servlet{

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init().... servlet被创建");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("ServletConfig()....");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service()....");
        System.out.println("servlet创建成功");
    }

    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo()....");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy()....");
        System.out.println("bye!");
    }
}
