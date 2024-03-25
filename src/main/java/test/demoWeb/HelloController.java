package test.demoWeb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController
{
    @GetMapping("/")
    public String getIndex(Model model){
       model.addAttribute("header" ,
               "Springboot");
       return "index"; // view name
    }
    @GetMapping("/you")
    public String getIndex2(Model model){
        model.addAttribute("header" ,
                "Hello World");
        return "index"; //view name
    }
}
