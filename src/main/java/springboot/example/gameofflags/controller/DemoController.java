package springboot.example.gameofflags.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public String runDemo(){
        return "I came back!";
    }
}
