package pl.coderslab.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.entity.Category;
import pl.coderslab.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryFixtures {

    @Autowired
    CategoryRepository categoryRepository;

    public void createAndInsertIntoDb(){
        List<Category> categories = createCategories();
        categoryRepository.save(categories);
    }

    public List<Category> createCategories() {
        List<Category> categories = new ArrayList<>();

        Category cat1 = new Category();
        cat1.setName("SiFi");

        Category cat2 = new Category();
        cat2.setName("Fantasy");

        Category cat3 = new Category();
        cat1.setName("Thriller");

        categories.add(cat1);
        categories.add(cat2);
        categories.add(cat3);


        return categories;
    }
}

