package iwhale.cloudweb.test.Service;

import iwhale.cloudweb.test.domain.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(value = "cloudservice",fallback = HelloServiceFallback.class)  //指定服务名来绑定服务
public interface HelloService {

    @RequestMapping(value = "hello1",method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "hello2",method = RequestMethod.GET)
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "hello3",method = RequestMethod.POST)
    String hello(@RequestBody User user);

}
