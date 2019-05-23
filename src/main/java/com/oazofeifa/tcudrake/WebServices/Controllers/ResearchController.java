package com.oazofeifa.tcudrake.WebServices.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResearchController {

    @RequestMapping(value = "/investigacion")
    public ModelAndView getResearchMainPage(ModelAndView mv){

        //TODO Implementar la sección de investigación
        mv.setViewName("in-construction.html");

        return mv;
    }

}
