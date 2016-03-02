package core;

import health.WebSiteCommentCheck;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import resource.*;

import javax.servlet.DispatcherType;
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

        environment.servlets().addFilter("CrossOriginFilter", new CrossOriginFilter())
                .addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");


        final BlogResource blogResource = new BlogResource();
        final BlogCommentResource blogCommentResource = new BlogCommentResource();
        final SkillResource skillResource = new SkillResource();
        final StatusResource statusResource = new StatusResource();
        final CommentResource websiteresource = new CommentResource();
        final WebSiteCommentCheck health = new WebSiteCommentCheck(configuration.getTemplate());
        environment.jersey().register(blogResource);
        environment.jersey().register(blogCommentResource);
        environment.jersey().register(skillResource);
        environment.jersey().register(statusResource);
        environment.jersey().register(websiteresource);
    }

}
