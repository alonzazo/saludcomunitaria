package com.oazofeifa.tcudrake.WebServices.Controllers;

import com.oazofeifa.tcudrake.Persistence.Entities.BlogEntry;
import com.oazofeifa.tcudrake.Services.BlogEntriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    BlogEntriesService blogEntriesService;

    @RequestMapping(value = "/")
    public String getRoot(){
        return "redirect:inicio";
    }

    @RequestMapping(value = "/inicio")
    public ModelAndView getHome(ModelAndView modelAndView){
        try {
            List<BlogEntry> latestNews = blogEntriesService.findTop5NewsByOrderByEntryIdDesc();

            modelAndView.addObject("blogEntries", latestNews);
        }
        catch (Exception e){
            System.out.println("Error fetching the news");
        }

        modelAndView.setViewName("home");
        return modelAndView;
    }
}
