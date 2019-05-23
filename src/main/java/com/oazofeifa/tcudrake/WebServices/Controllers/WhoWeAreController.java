package com.oazofeifa.tcudrake.WebServices.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WhoWeAreController {

    @RequestMapping(value = "/quienes-somos")
    public ModelAndView getWhoWeArePage(ModelAndView mv){

        mv.setViewName("who-we-are");

        return mv;
    }
}
