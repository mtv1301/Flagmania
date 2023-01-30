package springboot.example.gameofflags.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class WebSecurityInitializer extends AbstractSecurityWebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
    }
}
