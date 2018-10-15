package com.oazofeifa.tcudrake.WebServices.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = {"/home","/"})
    public ModelAndView getHome(ModelAndView modelAndView){
        modelAndView.setViewName("home");
        return modelAndView;
    }
}
