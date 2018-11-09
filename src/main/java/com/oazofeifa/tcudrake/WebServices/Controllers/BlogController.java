package com.oazofeifa.tcudrake.WebServices.Controllers;

import com.oazofeifa.tcudrake.Persistence.Entities.BlogEntry;
import com.oazofeifa.tcudrake.Persistence.Entities.User;
import com.oazofeifa.tcudrake.Services.BlogEntriesService;
import com.oazofeifa.tcudrake.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private BlogEntriesService blogEntriesService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/blogs")
    public ModelAndView getBlogMainPage(ModelAndView mv){
        List<BlogEntry> blogEntries = blogEntriesService.findAllByOrderByEntryIdDesc(); //Cambiar por

        mv.setViewName("blog");
        mv.addObject("blogEntries", blogEntries);
        return mv;
    }

    @RequestMapping(value = "/blogs/{blogId}")
    public ModelAndView getSpecificBlog(@PathVariable String blogId, ModelAndView mv){
        // Buscamos la entrada en el id solicitado
        BlogEntry blogEntry = blogEntriesService.findById(Integer.valueOf(blogId));
        //Si no está volvemos a la vista de selección de blogs
        if (blogEntry == null)
            mv.setViewName("redirect:blog");

        //Buscamos el nombre del autor, no el email
        User author = userService.findById(blogEntry.getUseremailFk());
        String authorName = author.getName() + " " + author.getLastname();

        //Agregamos el entry
        mv.addObject(blogEntry);
        mv.addObject("authorName",authorName);
        mv.setViewName("blog-entry");
        return mv;
    }

}
