package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorDao authorDao;

    @Autowired
    Validator validator;

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
    public String form(@ModelAttribute Author author, HttpServletRequest request, Model model) {
        return validateAuthor(author, request, model);
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("author", authorDao.findById(id));
        return "author/form";
    }

    @PostMapping("/edit/{id}")
    public String edit(@ModelAttribute Author author, HttpServletRequest request, @PathVariable Long id, Model model) {
        return validateAuthor(author, request, model);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, HttpServletRequest request){
        authorDao.delete(authorDao.findById(id));
        return "redirect:" + request.getContextPath() + "/author/list";
    }

    private String validateAuthor(@ModelAttribute Author author, HttpServletRequest request, Model model) {
        Set<ConstraintViolation<Author>> violations = validator.validate(author);
        if (!violations.isEmpty()) {
            model.addAttribute("author", author);
            model.addAttribute("errors", violations);
            return "author/form";
        }
        authorDao.save(author);
        return "redirect:" + request.getContextPath() + "/author/list";
    }
}
