package iwhale.cloudweb.test.Controller;

import iwhale.cloudweb.test.Service.HelloService;
import iwhale.cloudweb.test.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/helloFang",method = RequestMethod.GET)
    public String helloFang(){
        StringBuilder sb=new StringBuilder();
        sb.append(helloService.hello("hjy")).append("\n");
        sb.append(helloService.hello("hjy",33)).append("\n");
        sb.append(helloService.hello(new User("hjy",33))).append("\n");
        return sb.toString();
    }
}
