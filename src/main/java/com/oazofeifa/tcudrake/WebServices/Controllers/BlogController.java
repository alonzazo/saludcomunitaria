package com.oazofeifa.tcudrake.WebServices.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {

    @RequestMapping(value = "/blogs")
    public ModelAndView getBlogMainPage(ModelAndView mv){
        mv.setViewName("blog");
        return mv;
    }

    @RequestMapping(value = "/blogs/{blogId}")
    public ModelAndView getSpecificBlog(@PathVariable String blogId, ModelAndView mv){
        System.out.println(blogId);

        mv.addObject(blogId);
        mv.setViewName("blog-entry");
        return mv;
    }

}
