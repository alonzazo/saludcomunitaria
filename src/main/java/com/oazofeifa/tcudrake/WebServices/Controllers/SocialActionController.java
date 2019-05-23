package com.oazofeifa.tcudrake.WebServices.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SocialActionController {

    @RequestMapping(value = "/accion-social")
    public ModelAndView getSocialActionPage(ModelAndView mv){

        //TODO Implementar la sección de accion social
        mv.setViewName("in-construction");

        return mv;
    }
}
