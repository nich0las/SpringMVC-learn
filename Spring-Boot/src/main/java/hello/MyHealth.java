package hello;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyHealth implements HealthIndicator {


    @Override
    public Health health() {
        return  new Health.Builder().down().build() ;
    }
}