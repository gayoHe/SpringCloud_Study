package iwhale.cloud_service.test.controller;

import iwhale.cloud_service.test.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class HelloController {

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    public String hello(@RequestParam String name) throws Exception{
        ServiceInstance instance=client.getLocalServiceInstance();
        System.out.println("request is coming..");
        //测试超时
        //Thread.sleep(8000);
        return "ServiceId："+instance.getServiceId()+
                ", port："+instance.getPort()+",  参数为："+name;
    }

    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    public User hello(@RequestHeader String name, @RequestHeader Integer age){
        return new User(name,age);
    }

    @RequestMapping(value = "/hello3",method = RequestMethod.POST)
    public String hello(@RequestBody User user){
        return "Hello "+user.getName()+", "+user.getAge();
    }
}
