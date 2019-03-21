package pl.coderslab.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitDataFixtures {

    @Autowired
    CategoryFixtures categoryFixtures;

    @Autowired
    PublisherFixtures publisherFixtures;

    @Autowired
    AuthorFixtures authorFixtures;

    @PostConstruct
    public void initData(){
        System.out.println("Init data");
        categoryFixtures.createAndInsertIntoDb();
        publisherFixtures.createAndInsertIntoDb();
        authorFixtures.createAndInsertIntoDb();
    }
}
