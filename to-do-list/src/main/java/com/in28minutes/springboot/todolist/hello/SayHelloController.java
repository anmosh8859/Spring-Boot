package com.in28minutes.springboot.todolist.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class SayHelloController {

    @RequestMapping("say-hello")
    public @ResponseBody String sayHello(){
        return "Hello! What are you doing?";
    }

    @RequestMapping("say-hello-html")
    public @ResponseBody String sayHelloHtml(){
        return """
                <!doctype HTML>
                <html>
                    <head>
                        <title>My first HTML page</title>
                    </head>
                    <body>To-do-list web page with <body>
                    </body>
                </html>
                """;
    }

    @RequestMapping("say-hello-jsp")
    public String sayHelloJsp(){
        return "sayHello";
    }

}
