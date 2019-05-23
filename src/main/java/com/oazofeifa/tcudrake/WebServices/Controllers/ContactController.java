package com.oazofeifa.tcudrake.WebServices.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {

    @RequestMapping(value = "/contactanos")
    public ModelAndView getContactPage(ModelAndView mv){

        //TODO Implementar la sección de contactenos
        mv.setViewName("in-construction");

        return mv;
    }
}
