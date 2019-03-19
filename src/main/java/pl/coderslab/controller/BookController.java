package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookDao bookDao;

    @Autowired
    AuthorDao authorDao;

    @Autowired
    PublisherDao publisherDao;

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("book", new Book());
        return "book/form";
    }

    @PostMapping("/form")
    public String form(@ModelAttribute Book book, HttpServletRequest request){
        bookDao.save(book);
        return "redirect:"+request.getContextPath()+"/book/list";
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("books", bookDao.findAll());
        return "/book/list";
    }

    @GetMapping("/edit/{bookId}")
    public String edit(Model model, @PathVariable Long bookId) {
        model.addAttribute("book", bookDao.findById(bookId));
        return "book/form";
    }

    @PostMapping("/edit/{id}")
    public String edit(@ModelAttribute Book book, @PathVariable Long id, HttpServletRequest request){
        bookDao.save(book);
        return "redirect:"+request.getContextPath()+"/book/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model,@PathVariable Long id){
        model.addAttribute("book", bookDao.findById(id));
        return "/book/delete";
    }

    @GetMapping("delete/confirm/{id}")
    public String confirmDelete(HttpServletRequest request, @PathVariable Long id){
        bookDao.delete(bookDao.findById(id));
        return "redirect:"+request.getContextPath()+"/book/list";
    }



    @ModelAttribute("publishers")
    public List<Publisher> publisherList(){
        return publisherDao.findAll();
    }

    @ModelAttribute("authors")
    public List<Author> authorList(){
       return authorDao.findAll();
    }
}
