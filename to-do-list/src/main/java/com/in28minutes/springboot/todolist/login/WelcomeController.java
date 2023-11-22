package com.in28minutes.springboot.todolist.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

//    @Autowired
//    private AuthenticationService authe;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goToWelcome(ModelMap map){
        map.put("name",getLoggedUsername());
        return "welcome";
    }

    private String getLoggedUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

//    @RequestMapping(value = "login", method = RequestMethod.POST)
//    public String goToWelcomePage(@RequestParam String name,
//                                  @RequestParam String password,
//                                  ModelMap model){
//
//        if(authe.authenticate(name,password)){
//            model.put("name", name);
//            return "welcome";
//        }
//
//        model.put("errorMessage","Invalid Credentials");
//        return "login";
//    }
}