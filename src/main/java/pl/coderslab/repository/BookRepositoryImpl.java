package pl.coderslab.repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Transactional
public class BookRepositoryImpl implements BookRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void resetRating(int rating) {
        Query query = entityManager.createQuery("update Book set rating = :rating");
        query.setParameter("rating", rating);
        query.executeUpdate();
    }
}
