package iwhale.cloud_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@EnableDiscoveryClient
@SpringBootApplication
@EnableResourceServer
public class CloudServiceApplication extends ResourceServerConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(CloudServiceApplication.class, args);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception{
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/**").authenticated()
                .antMatchers(HttpMethod.GET,"test")
                .hasAuthority("WRIGHT_READ");
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception{
        resources.resourceId("WRIGTH")
                .tokenStore(jwtTokenStore());
    }

    @Bean
    public TokenStore jwtTokenStore(){
        return new JwtTokenStore(jwtTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtTokenConverter(){
        JwtAccessTokenConverter converter=new JwtAccessTokenConverter();
        converter.setSigningKey("springcloud123");
        return converter;
    }
}
