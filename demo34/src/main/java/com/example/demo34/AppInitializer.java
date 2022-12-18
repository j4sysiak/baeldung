package com.example.demo34;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {

        // https://www.baeldung.com/spring-xml-vs-java-config
        // https://github.com/eugenp/tutorials/tree/master/spring-web-modules/spring-mvc-java
        // https://github.com/eugenp/tutorials/tree/master/spring-web-modules/spring-mvc-xml

        // We can register a servlet implementing a WebApplicationInitializer. This is the equivalent of the XML configuration above
        // So we used Java to declare the servlet and bind it to a URL mapping but we kept the configuration in a separated XML file: dispatcher-config.xml.
        // XmlWebApplicationContext context = new XmlWebApplicationContext();
        // context.setConfigLocation("/WEB-INF/spring/dispatcher-config.xml");

        //100% Java Configuration
        //The first thing we will need to do is create the application context for the servlet.
        //This time we will use an annotation based context so that we can use Java and annotations for configuration and remove the need for XML files like dispatcher-config.xml:
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(Demo34Application.class);
        context.setConfigLocation("com.baeldung.spring");
        context.scan("com.baeldung");
        container.addListener(new ContextLoaderListener(context));

        ServletRegistration.Dynamic dispatcher =
                container.addServlet("mvc", new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");  //  http://localhost:8080
    }
}
