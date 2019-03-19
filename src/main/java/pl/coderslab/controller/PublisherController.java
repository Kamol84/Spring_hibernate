package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Publisher;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/publisher")
public class PublisherController {

    @Autowired
    PublisherDao publisherDao;

    @GetMapping("/form")
    public String form(Model moderl){
        moderl.addAttribute("publisher", new Publisher());
        return "publisher/form";
    }

    @PostMapping("/form")
    public String form(@ModelAttribute Publisher publisher, HttpServletRequest request){
        publisherDao.save(publisher);
        return "redirect:"+request.getContextPath()+"/publisher/list";
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("publishers", publisherDao.findAll());
        return "publisher/list";
    }

}
