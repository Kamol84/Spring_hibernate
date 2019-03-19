package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookDao bookDao;

    @Autowired
    AuthorDao authorDao;





    @GetMapping("/testadd")
    @ResponseBody
    public void testAdd() {

        Author author = new Author();
        author.setFirstName("Evan");
        author.setLastName("Currie");
        authorDao.save(author);

        Author author2 = new Author();
        author2.setFirstName("Jan");
        author2.setLastName("Kowalski");
        authorDao.save(author2);


        Book book = new Book();
        book.getAuthors().add(author);
        book.setTitle("Odysey One");
        book.setRating(6);
        bookDao.save(book);

        Book book2 = new Book();
        book2.getAuthors().add(author);
        book2.setTitle("Kot Ciapek");
        book2.setRating(4);
        bookDao.save(book2);

        Book book3 = new Book();
        book3.getAuthors().add(author2);
        book3.setTitle("Pies Cipek");
        book3.setRating(9);
        bookDao.save(book3);
    }



    @GetMapping("/{bookId}")
    @ResponseBody
    public String getBookById(@PathVariable Long bookId) {
        return bookDao.findById(bookId).toString();
    }

    @GetMapping("/allBooks")
    @ResponseBody
    public String allBooks(){
        return  bookDao.readAll().toString();
    }


    @GetMapping("/raiting/{rating}")
    @ResponseBody
    public String getBookByRating(@PathVariable int rating){
        return bookDao.getRatingList(rating).toString();
    }


    @GetMapping("/update/{bookId}")
    @ResponseBody
    public void updateBook(@PathVariable Long bookId) {
        Book bookToUpdate = bookDao.findById(bookId);
        bookToUpdate.setTitle("Inny tytuł");
        bookDao.save(bookToUpdate);
    }

    @GetMapping("/delete/{bookId}")
    @ResponseBody
    public void deleteBook(@PathVariable Long bookId) {
        Book bookToDelete = bookDao.findById(bookId);
        bookDao.delete(bookToDelete);
    }


}
