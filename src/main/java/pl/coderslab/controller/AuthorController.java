package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorDao authorDao;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("authors", authorDao.findAll());
        return "author/list";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("author", new Author());
        return "author/form";
    }

    @PostMapping("/form")
    public String form(@ModelAttribute Author author, HttpServletRequest request) {
        authorDao.save(author);
        return "redirect:" + request.getContextPath() + "/author/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("author", authorDao.findById(id));
        return "author/form";
    }

    @PostMapping("/edit/{id}")
    public String edit(@ModelAttribute Author author, HttpServletRequest request, @PathVariable Long id) {
        authorDao.save(author);
        return "redirect:" + request.getContextPath() + "/author/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, HttpServletRequest request){
        authorDao.delete(authorDao.findById(id));
        return "redirect:" + request.getContextPath() + "/author/list";
    }


}
