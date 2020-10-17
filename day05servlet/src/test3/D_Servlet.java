package test3;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author:Aurevoir
 * @date: 2020/2/22  14:45
 */
public class D_Servlet extends C_Servlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        String value = getInitParameter("name");
        System.out.println(value);
    }
}
