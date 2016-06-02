package core;

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


        final BlogResource blogResource = BlogResource.getInstance();
        final BlogCommentResource blogCommentResource = BlogCommentResource.getInstance();
        environment.jersey().register(blogResource);
        environment.jersey().register(blogCommentResource);
    }

}
