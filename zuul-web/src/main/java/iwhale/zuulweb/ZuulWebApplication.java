package iwhale.zuulweb;

import iwhale.zuulweb.test.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableZuulProxy
@SpringCloudApplication
@EnableOAuth2Sso
public class ZuulWebApplication extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        SpringApplication.run(ZuulWebApplication.class, args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/login","/cloudservice/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf()
                .disable();
    }

    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }
}
