package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {


    @PersistenceContext
    EntityManager entityManager;

    public void save(Author entity) {
        if (entity.getId() == null) {
            add(entity);
        } else {
            update(entity);
        }

    }


    public List<Author> findAll() {
        Query query = entityManager.createQuery("SELECT author FROM Author author order by author.lastName");
        return query.getResultList();
    }


    public Author findById(Long id) {
        return entityManager.find(Author.class, id);
    }


    public void delete(Author entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }


    private void add(Author entity) {
        entityManager.persist(entity);
    }

    private void update(Author entity) {
        entityManager.merge(entity);
    }
}
