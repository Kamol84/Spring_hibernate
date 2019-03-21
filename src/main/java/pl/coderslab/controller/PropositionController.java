package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.groups.Default;
import java.util.List;

@Controller
@RequestMapping("/proposition")
public class PropositionController {

    @Autowired
    BookDao bookDao;

    @Autowired
    AuthorDao authorDao;

    @Autowired
    PublisherDao publisherDao;

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("book", new Book());
        return "proposition/form";
    }

    @PostMapping("/form")
    public String form(@Validated({Default.class}) Book book, BindingResult bookError, HttpServletRequest request) {
        return bookValidation(book, bookError, request);
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("book", bookDao.findById(id));
        return "proposition/form";
    }

    @PostMapping("/edit/{id}")
    public String edit(@Validated({Default.class}) Book book, BindingResult bookError, @PathVariable Long id, HttpServletRequest request) {
        return bookValidation(book, bookError, request);
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("books", bookDao.findAllProposition());
        return "/proposition/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(HttpServletRequest request, @PathVariable Long id) {
        bookDao.delete(bookDao.findById(id));
        return "redirect:" + request.getContextPath() + "/proposition/list";
    }

    @ModelAttribute("publishers")
    public List<Publisher> publisherList() {
        return publisherDao.findAll();
    }

    @ModelAttribute("authors")
    public List<Author> authorList() {
        return authorDao.findAll();
    }

    private String bookValidation(@Valid Book book, BindingResult bookError, HttpServletRequest request) {
        if (bookError.hasErrors()) {
            return "proposition/form";
        }
        book.setProposition(true);
        bookDao.save(book);
        return "redirect:" + request.getContextPath() + "/proposition/list";
    }
}