package test3;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author:Aurevoir
 * @date: 2020/2/22  13:27
 */
public class C_Servlet implements Servlet {
    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("每次处理请求都会被调用");
    }

    @Override
    public String getServletInfo() {
        return "Information";
    }

    @Override
    public void destroy() {
        System.out.println("destroy!!!!");
    }

    //模拟GenericServlet，实现其中的部分方法
    public ServletContext getServletContext(){
        return getServletConfig().getServletContext();
    }

    public String getServletName(){
        return getServletConfig().getServletName();
    }

    public String getInitParameter(String name){
        return config.getInitParameter(name);
    }
}
