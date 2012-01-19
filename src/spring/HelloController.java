package spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Keesun Baik
 */
@Controller
public class HelloController {
    
    @RequestMapping("/hi")
    public @ResponseBody String hi() {
        return "Hi Spring";
    }
}
