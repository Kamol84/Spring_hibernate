package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>, BookRepositoryCustom {

    List<Book> findAllByPropositionAndCategoryId(boolean proposition, Long id);

    List<Book> findAllByPropositionAndCategory(boolean proposition, String category);

    List<Book> findAllByPropositionAndTitleLike(boolean proposition, String title);

    List<Book> findAllByAuthors(Author author);

    List<Book> findAllByAuthorsIn(List<Author> authorList);

    List<Book> findAllByPublisher(Publisher publisher);

    List<Book> findAllByRatingBetween(Long min, Long max);

    Book findBookByCategoryOrderByTitle(Category category);

//-------------------

    @Query("select b from Book b where b.title = :title")
    List<Book> getByTitle(@Param("title") String title);

    @Query("select b from Book b where b.category = :category")
    List<Book> getAllByCategory(@Param("category") Category category);

    @Query("select b from Book b where b.rating between  :minRaiting and :maxRaiting")
    List<Book> getAllByRating(@Param("minRaiting") Long min, @Param("maxRaiting") Long max);

    @Query("select b from Book b where b.publisher = :publisher")
    List<Book> getAllbyPublisher(@Param("publisher") Publisher publisher);

    @Query("select b from Book b where b.category = :category order by b.title ")
    Book getByCategory(@Param("category") Category category);


}