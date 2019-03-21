package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findByEmail(String email);

    Author findByPesel(String pesel);

    List<Author> findAllByLastNameLike(String lastName);

    //--------

    @Query("select a from Author a where a.email like :email%")
    List<Author> getAllByEmail (@Param("email") String email);

    @Query("select a from Author a where a.pesel like :pesel%")
    List<Author> getAllByPesel (@Param("pesel") String pesel);


}
