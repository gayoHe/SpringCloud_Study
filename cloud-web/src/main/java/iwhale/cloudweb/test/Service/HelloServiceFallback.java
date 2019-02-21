package iwhale.cloudweb.test.Service;

import iwhale.cloudweb.test.domain.User;
import org.springframework.stereotype.Component;

public class HelloServiceFallback implements HelloService{

    @Override
    public String hello(String name) {
        return "error";
    }

    @Override
    public User hello(String name, Integer age) {
        return new User("未知",0);
    }

    @Override
    public String hello(User user) {
        return "error";
    }
}
