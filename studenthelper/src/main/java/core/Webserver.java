package core;

import jakarta.servlet.http.HttpServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import requests.HttpRequest;

import java.lang.reflect.InvocationTargetException;

public class Webserver {
    private  Wrapper servletWrapper;
    private Context context;
    private Tomcat tomcat;

    public Webserver(){
        tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();
        context = tomcat.addContext("",null);

    }

    /**
     * Start tomcat server
     */
    public void startServer(){
        try {
            tomcat.start();
        } catch (LifecycleException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Construct Route
     * @param servlet A class extends HttpServlet
     * @param servletName Servlet name
     * @param route route path (e.g., /path)
     */
    public void route(Class<? extends HttpServlet> servlet,String servletName,String route){
        try {
           servletWrapper = tomcat.addServlet(context,servletName,servlet.getDeclaredConstructor().newInstance());
           servletWrapper.addMapping(route);
           servletWrapper.setLoadOnStartup(1);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
