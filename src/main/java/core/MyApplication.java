package core;

import health.WebSiteCommentCheck;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import resource.BlogResource;
import resource.SkillResource;
import resource.StatusResource;
import resource.WebSiteResource;

public class MyApplication extends Application<ApplicationConfiguration> {

    public static void main(String[] args) throws Exception {
        new MyApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<ApplicationConfiguration> bootstrap){

    }

    @Override
    public void run(ApplicationConfiguration configuration, Environment environment){


        final BlogResource blogResource = new BlogResource();
        final SkillResource skillResource = new SkillResource();
        final StatusResource statusResource = new StatusResource();
        final WebSiteResource websiteresource = new WebSiteResource();
        final WebSiteCommentCheck health = new WebSiteCommentCheck(configuration.getTemplate());
        environment.healthChecks().register("template", health);
        environment.jersey().register(blogResource);
        environment.jersey().register(skillResource);
        environment.jersey().register(statusResource);
        environment.jersey().register(websiteresource);
    }

}
