package com.adobe.aem.guides.wknd.core.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(
        name = "AEM My First Servlet Config",
        description = "This configuration creates servlet."
)
public @interface MyFirstServletConfig {
    @AttributeDefinition(
            name = "Welcome Message",
            description = "Enter the welcome message for our servlet."
    )
    String getWelcomeMessage();
}
