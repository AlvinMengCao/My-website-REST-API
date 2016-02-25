package health;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created by alvin on 2/24/16.
 */
public class WebSiteCommentCheck extends HealthCheck {
    private final String template;

    public WebSiteCommentCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception{
        return Result.healthy();
    }
}
