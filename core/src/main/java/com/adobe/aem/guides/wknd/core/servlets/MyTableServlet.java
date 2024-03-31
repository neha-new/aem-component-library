package com.adobe.aem.guides.wknd.core.servlets;

import com.google.gson.JsonObject;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.Servlet;
import java.io.IOException;

@Component(
        service= Servlet.class,
        property = {
                "sling.servlet.resourceTypes" + "=wknd/components/mytable",
                "sling.servlet.methods" + "=GET",
                "sling.servlet.extensions" + "=json"
        })
public class MyTableServlet extends SlingAllMethodsServlet {
    private static final Logger log = LoggerFactory.getLogger(MyTableServlet.class);
    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        log.info("The servlet is called");
        String path = request.getParameter("resourcePath");
        Resource resource = request.getResourceResolver().resolve(path);
        ValueMap vm = resource.getValueMap();
        String[] ht = vm.get("headings", String[].class);
        JsonObject json = new JsonObject();
        int i = 0;
        String prop = "headings";
        for(String str: ht)
        {
            String index = Integer.toString(i);
            json.addProperty(prop+index,str);
            i++;
        }
        response.getWriter().write(json.toString());

        log.info("The json {}",json);
        log.info("The value of ht {}",ht.length);
        log.info("The Valuemap is {}", vm);
        log.info("The path is : {}",path);
    }
}
