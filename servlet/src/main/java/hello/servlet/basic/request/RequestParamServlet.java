package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 1. 파라미터 전송 기능
 * http://localhost:8080/request-param?username=hello&age=20
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        Enumeration<String> parameterNames = req.getParameterNames();
//        System.out.println("parameterNames = " + parameterNames);
        req.getParameterNames().asIterator()
                .forEachRemaining(par -> System.out.println(par +": "+ req.getParameter(par)));

        System.out.println();
        String username = req.getParameter("username");
        String age = req.getParameter("age");

        System.out.println("age = " + age);
        System.out.println("username = " + username);
        System.out.println();

        String[] usernames = req.getParameterValues("username");
        for (String s : usernames) {
            System.out.println("name = " + s);
        }
        System.out.println();


    }
}
