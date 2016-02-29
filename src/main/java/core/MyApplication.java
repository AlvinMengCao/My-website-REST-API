package core;

import health.WebSiteCommentCheck;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import resource.BlogResource;
import resource.SkillResource;
import resource.StatusResource;
import resource.WebSiteResource;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

public class MyApplication extends Application<ApplicationConfiguration> {

    public static void main(String[] args) throws Exception {
        new MyApplication().run(args);
    }

    @Override
    public String getName(){
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<ApplicationConfiguration> bootstrap){

    }

    @Override
    public void run(ApplicationConfiguration configuration, Environment environment){

        FilterRegistration.Dynamic filter = environment.servlets().addFilter("CORSFilter", CrossOriginFilter.class);
        filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, environment.getApplicationContext().getContextPath()+"*");
        filter.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "GET,PUT,POST,OPTIONS");
        filter.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "allowed_host");
        filter.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "Origin, Content-Type, Accept");
        filter.setInitParameter(CrossOriginFilter.ALLOW_CREDENTIALS_PARAM, "true");

        final BlogResource blogResource = new BlogResource();
        final SkillResource skillResource = new SkillResource();
        final StatusResource statusResource = new StatusResource();
        final WebSiteResource websiteresource = new WebSiteResource();
        final WebSiteCommentCheck health = new WebSiteCommentCheck(configuration.getTemplate());
        environment.jersey().register(blogResource);
        environment.jersey().register(skillResource);
        environment.jersey().register(statusResource);
        environment.jersey().register(websiteresource);
    }

}
