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
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;
import pl.coderslab.repository.BookRepository;
import pl.coderslab.repository.CategoryRepository;
import pl.coderslab.validationsGroups.AdvanceValidation;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.groups.Default;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookDao bookDao;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorDao authorDao;

    @Autowired
    PublisherDao publisherDao;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("book", new Book());
        return "book/form";
    }

    @PostMapping("/form")
    public String form(@Validated({Default.class, AdvanceValidation.class}) Book book, BindingResult bookError, HttpServletRequest request) {
        return bookValidation(book, bookError, request);
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("book", bookDao.findById(id));
        return "book/form";
    }

    @PostMapping("/edit/{id}")
    public String edit(@Validated({Default.class, AdvanceValidation.class}) Book book, BindingResult bookError, @PathVariable Long id, HttpServletRequest request) {
        return bookValidation(book, bookError, request);
    }

    @GetMapping("/list")
    public String list(Model model, HttpServletRequest request) {
        boolean proposition = Boolean.parseBoolean(request.getParameter("pro"));
        String catId = request.getParameter("catid");
        String title = request.getParameter("title");

        if (catId != null) {
            model.addAttribute("books", bookRepository.findAllByPropositionAndCategoryId(proposition, Long.parseLong(catId)));
        } else if (title != null){
            model.addAttribute("books", bookRepository.findAllByPropositionAndTitleLike(proposition,"%" + title + "%"));
        } else {
            model.addAttribute("books", bookDao.findAll());
        }

        return "/book/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id) {
        model.addAttribute("book", bookDao.findById(id));
        return "/book/delete";
    }

    @GetMapping("delete/confirm/{id}")
    public String confirmDelete(HttpServletRequest request, @PathVariable Long id) {
        bookDao.delete(bookDao.findById(id));
        return "redirect:" + request.getContextPath() + "/book/list";
    }

    @GetMapping("/reset/{setRating}")
    @ResponseBody
    public void reset(@PathVariable int setRating){
        bookRepository.resetRating(setRating);
    }

    @ModelAttribute("publishers")
    public List<Publisher> publisherList() {
        return publisherDao.findAll();
    }

    @ModelAttribute("categories")
    public List<Category> categoryList() {
        return categoryRepository.findAll();
    }

    @ModelAttribute("authors")
    public List<Author> authorList() {
        return authorDao.findAll();
    }

    private String bookValidation(@Valid Book book, BindingResult bookError, HttpServletRequest request) {
        if (bookError.hasErrors()) {
            return "book/form";
        }
        book.setProposition(false);
        bookDao.save(book);
        return "redirect:" + request.getContextPath() + "/book/list";
    }
}
