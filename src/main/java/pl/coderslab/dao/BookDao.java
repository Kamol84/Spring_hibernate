package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Book entity) {

        if (entity.getId() == null) {
            add(entity);
        } else {
            update(entity);
        }
    }

    public List<Book> findAll() {
        Query query = entityManager.createQuery("SELECT book FROM Book book order by book.title");
        return query.getResultList();
    }

    public List<Book> getRatingList(int rating){
        Query query = entityManager.createQuery("SELECT book FROM Book book where rating >:rating");
        query.setParameter("rating", rating);
        List<Book> booksByRating = query.getResultList();
        return booksByRating;
    }

    public Book findById(Long id) {
        return entityManager.find(Book.class, id);
    }


    public void delete(Book entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

    private void add(Book entity) {
        entityManager.persist(entity);
    }

    private void update(Book entity) {
        entityManager.merge(entity);
    }
}
