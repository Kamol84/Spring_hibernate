package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByPropositionAndCategoryId(boolean proposition, Long id);

    List<Book> findAllByPropositionAndCategory(boolean proposition, String category);

    List<Book> findAllByPropositionAndTitleLike(boolean proposition,String title);

    List<Book> findAllByAuthors(Author author);

    List<Book> findAllByAuthorsIn(List<Author> authorList);

    List<Book> findAllByPublisher(Publisher publisher);

    List<Book> findAllByRatingBetween(Long min, Long max);

    Book findBookByCategoryOrderByTitle(Category category);




}