package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2015/2/10.
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String index(){
        return "Greetings from Spring Boot!" ;
    }
}
