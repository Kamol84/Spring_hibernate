package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Publisher;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/publisher")
public class PublisherController {

    @Autowired
    PublisherDao publisherDao;

    @GetMapping("/form")
    public String form(Model moderl) {
        moderl.addAttribute("publisher", new Publisher());
        return "publisher/form";
    }

    @PostMapping("/form")
    public String form(@Valid Publisher publisher, BindingResult publisherError, HttpServletRequest request) {
        if(publisherError.hasErrors()){
            return "publisher/form";
        }
        publisherDao.save(publisher);
        return "redirect:" + request.getContextPath() + "/publisher/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("publishers", publisherDao.findAll());
        return "publisher/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("publisher", publisherDao.findById(id));
        return "publisher/form";
    }

    @PostMapping("/edit/{id}")
    public String edit(@Valid Publisher publisher,BindingResult publisherError, HttpServletRequest request, @PathVariable Long id) {
       if(publisherError.hasErrors()){
           return "/publisher/form";
       }

        return "redirect:" + request.getContextPath() + "/publisher/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, HttpServletRequest request) {
        publisherDao.delete(publisherDao.findById(id));
        return "redirect:" + request.getContextPath() + "/publisher/list";
    }
}
