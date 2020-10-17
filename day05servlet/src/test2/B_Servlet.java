package test2;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author:Aurevoir
 * @date: 2020/2/22  13:14
 */
public class B_Servlet extends HttpServlet {
    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String paramVal = this.config.getInitParameter("name");
        response.getWriter().println(paramVal);

        Enumeration<String> enumeration = config.getInitParameterNames();
        while(enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String val = this.config.getInitParameter(name);
            response.getWriter().println(name+"="+val);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
