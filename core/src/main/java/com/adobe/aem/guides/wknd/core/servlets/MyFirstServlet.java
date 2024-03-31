package com.adobe.aem.guides.wknd.core.servlets;

import com.adobe.aem.guides.wknd.core.config.MyFirstServletConfig;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;
import javax.servlet.Servlet;
import java.io.IOException;
import java.util.Dictionary;

@Component(
        service=Servlet.class,
        property={
                Constants.SERVICE_DESCRIPTION + "=Custom Servlet",
                "sling.servlet.methods=" + HttpConstants.METHOD_GET,
                "sling.servlet.methods=" + HttpConstants.METHOD_POST,
                "sling.servlet.paths=" + "/bin/practice/ocd"
        }
)
@Designate(ocd = MyFirstServletConfig.class)// to add configuartions to OSGI services with the help of @Designate annotation
public class MyFirstServlet extends SlingSafeMethodsServlet {

    private static final Logger log = LoggerFactory.getLogger(MyFirstServlet.class);
    private static final long serialVersionUID = 1L;

    @Resource(name="BundleContext")
    private BundleContext context;

    @Reference//used to inject a service into the component
    private ConfigurationAdmin configAdmin;

    @Override//override the method of parent class
    protected void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        Configuration myServletConfig = configAdmin.getConfiguration("com.adobe.aem.guides.wknd.core.servlets.MyFirstServlet");
        Dictionary <String,Object> properties = myServletConfig.getProperties();
        String result = properties.get("getWelcomeMessage").toString();
        log.info("Value is {}",myServletConfig.getProperties().toString());
        resp.getWriter().write("<h4>"+result+"</h4>");
        resp.sendRedirect("https://www.google.com");
    }

    /*public ConfigurationAdmin getConfigAdmin() {
        configAdmin
    }*/
}
//
