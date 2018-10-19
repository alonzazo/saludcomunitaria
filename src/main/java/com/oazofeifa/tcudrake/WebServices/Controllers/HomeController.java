package com.oazofeifa.tcudrake.WebServices.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String getRoot(){
        return "redirect:inicio";
    }

    @RequestMapping(value = "/inicio")
    public ModelAndView getHome(ModelAndView modelAndView){
        modelAndView.setViewName("home");
        return modelAndView;
    }
}
