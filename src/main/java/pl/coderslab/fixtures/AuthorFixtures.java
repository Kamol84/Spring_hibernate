package pl.coderslab.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.entity.Author;
import pl.coderslab.repository.AuthorRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class AuthorFixtures {

    @Autowired
    AuthorRepository authorRepository;

    public void createAndInsertIntoDb() {
        List<Author> authors = createAuthors();
        authorRepository.save(authors);
    }

    private List<Author> createAuthors() {
        List<Author> authors = new ArrayList<>();

        Author aut1 = new Author();
        aut1.setFirstName("Anna");
        aut1.setLastName("Jakaś");
        aut1.setPesel("08092314629");
        aut1.setEmail("anna@jakas.pl");
        aut1.setYearOfBirth(LocalDate.parse("2000-10-05"));

        Author aut2 = new Author();
        aut2.setFirstName("Kamil");
        aut2.setLastName("Jakaś");
        aut2.setPesel("08092314629");
        aut2.setEmail("kamil@jakas.pl");
        aut2.setYearOfBirth(LocalDate.parse("1984-10-05"));

        authors.add(aut1);
        authors.add(aut2);


        return authors;
    }


}
