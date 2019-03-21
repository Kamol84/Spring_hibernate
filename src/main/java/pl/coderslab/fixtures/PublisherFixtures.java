package pl.coderslab.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.entity.Publisher;
import pl.coderslab.repository.PublisherRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class PublisherFixtures {

    @Autowired
    PublisherRepository publisherRepository;

    public void createAndInsertIntoDb(){
        List<Publisher> publishers= createPublishers();
        publisherRepository.save(publishers);
    }

    public List<Publisher> createPublishers() {
        List<Publisher> publishers = new ArrayList<>();

        Publisher pub1 = new Publisher();
        pub1.setName("PWN");
        pub1.setNip("5225084294");
        pub1.setRegon("454342513");

        Publisher pub2 = new Publisher();
        pub2.setName("Helion");
        pub2.setNip("4976051432");
        pub2.setRegon("495728318");

        publishers.add(pub1);
        publishers.add(pub2);

        return publishers;
    }


}
