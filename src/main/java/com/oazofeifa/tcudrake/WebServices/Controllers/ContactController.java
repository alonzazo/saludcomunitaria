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
public class ContactController {

    @RequestMapping(value = "/contact")
    public ModelAndView getContactMainPage(ModelAndView mv){
        mv.setViewName("contact");
        return mv;
    }
}
