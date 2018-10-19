package com.oazofeifa.tcudrake.WebServices.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DataController {


    @RequestMapping(value = "/datos")
    public ModelAndView getDataPage(){
        return new ModelAndView("data");
    }
}
