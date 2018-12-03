package com.oazofeifa.tcudrake.WebServices.Controllers;

import com.oazofeifa.tcudrake.Persistence.Entities.BlogEntry;
import com.oazofeifa.tcudrake.Persistence.Entities.User;
import com.oazofeifa.tcudrake.Services.BlogEntriesService;
import com.oazofeifa.tcudrake.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.sql.Timestamp;
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

    @RequestMapping(value = "/blogs/nueva-entrada")
    public ModelAndView getAddBlogEntryForm(ModelAndView mv){
        mv.setViewName("add-blog-entry");
        return mv;
    }

    @RequestMapping(value = "/blogs/publicar-entrada", method = RequestMethod.POST)
    public @ResponseBody String postNewEntry(@RequestParam(value = "title-entry", required = true) String titleEntry,
                                             @RequestParam(value = "abstract-entry", required = true) String abstractEntry,
                                             @RequestParam(value = "content-entry", required = true) String contentEntry,
                                             @RequestParam(value = "show-in-news", required = false) Boolean showInNews,
                                             @RequestParam(value = "image-entry", required = false) String imageEntry){
        //Creamos el objeto para insertar
        BlogEntry blogEntry = new BlogEntry();
        blogEntry.setTitleEntry(titleEntry);
        blogEntry.setAbstractEntry(abstractEntry);
        blogEntry.setContentEntry(contentEntry);
        blogEntry.setCreationTimestamp(new Timestamp(System.currentTimeMillis()));
        blogEntry.setBroadcastingDate(new Timestamp(System.currentTimeMillis()));
        blogEntry.setUseremailFk(SecurityContextHolder.getContext().getAuthentication().getName().split(",")[0]);


        //Casteamos un Boolean a un byte array
        byte[] news = new byte[1];
        if (showInNews == null) showInNews = false;
        news[0] = showInNews ? (byte)1: (byte)0;
        blogEntry.setNews(news);

        //Colocamos la imagen default
        if (imageEntry == null) blogEntry.setImageUrl("images/backgrounds/default-blog-image.jpg");

        try {
            blogEntriesService.save(blogEntry);
        } catch (Exception ex){
            ex.printStackTrace();
            return "failed";
        }
        return "success";
    }

}
