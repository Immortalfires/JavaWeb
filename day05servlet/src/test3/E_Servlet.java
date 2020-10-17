package test3;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author:Aurevoir
 * @date: 2020/2/22  15:05
 */
public class E_Servlet extends GenericServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("添加自己的init()");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello,here is service");
    }

    @Override
    public void destroy() {
        System.out.println("释放资源！—— ！");
    }
}
