package pl.coderslab.dao;


import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PublisherDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Publisher entity) {

        if (entity.getId() == null) {
            add(entity);
        } else {
            update(entity);
        }
    }

    public List<Publisher> findAll() {
        Query query = entityManager.createQuery("SELECT p FROM Publisher p order by p.name");
        return query.getResultList();
    }


    public Publisher findById(Long id) {
        return entityManager.find(Publisher.class, id);
    }


    public void delete(Publisher entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

    private void add(Publisher entity) {
        entityManager.persist(entity);
    }

    private void update(Publisher entity) {
        entityManager.merge(entity);
    }

}
