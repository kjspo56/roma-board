package com.kjs.roma.environment.config;

import com.kjs.roma.resource.PostResource;
import com.kjs.roma.resource.UserResource;
import jakarta.servlet.ServletConfig;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ServletConfigAware;

@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig implements ServletConfigAware {

    private ServletConfig servletConfig;

    public JerseyConfig(){
        register(PostResource.class);
        register(UserResource.class);

        property(ServerProperties.RESPONSE_SET_STATUS_OVER_SEND_ERROR, true);
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        property(ServerProperties.BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK, true);
        property(ServletProperties.FILTER_FORWARD_ON_404, true);
    }

    @Override
    public void setServletConfig(ServletConfig servletConfig) {
        this.servletConfig = servletConfig;
    }

}
