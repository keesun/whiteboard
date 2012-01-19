package me.whiteship.board.modules.servlet.basic;

import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * @author Keesun Baik
 */
@WebServlet(urlPatterns = "/spring/*",
        initParams = {
                @WebInitParam(name = "contextConfigLocation", value = "classpath*:/spring.xml")})
public class SpringServlet extends DispatcherServlet {

}
