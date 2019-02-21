package iwhale.cloud_service.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@RestController
public class OauthController{

    @RequestMapping("/test")
    public String test(HttpServletRequest request) {
        System.out.println("-----------header------------");
        Enumeration headerNames=request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String key=(String) headerNames.nextElement();
            System.out.println(key+"："+request.getHeader(key));
        }
        return "helloooooooooo!";
    }

}
