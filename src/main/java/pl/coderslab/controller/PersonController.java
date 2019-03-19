package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.PersonDetails;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonDao personDao;


    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("person", new Person());
        return "person/form";

    }




    @GetMapping("/add")
    @ResponseBody
    public void addPeople() {
        Person person = new Person();
        person.setLogin("admin");
        person.setEmail("test@gmail.com");
        person.setPassword("admin");

        PersonDetails personDetails = new PersonDetails();
        personDetails.setFirstName("ABCD");
        personDetails.setLastName("ABCD");
        personDetails.setCity("test1");

        person.setPersonDetails(personDetails);
        personDao.save(person);

    }


    @GetMapping("/{personId}")
    @ResponseBody
    public String getPersonById(@PathVariable Long personId) {
        return personDao.findById(personId).toString();
    }


    @GetMapping("/showAll")
    @ResponseBody
    public String getPeopleList() {
        return personDao.readAll().toString();
    }


    @GetMapping("update/{personId}")
    @ResponseBody
    public void updatePerson(@PathVariable Long personId) {
        Person personToUpdate = personDao.findById(personId);
        personToUpdate.setLogin("INNY LOGIN");
        personToUpdate.getPersonDetails().setCity("INNE MIASTO");
        personDao.save(personToUpdate);
    }


    @GetMapping("/delete/{personId}")
    @ResponseBody
    public void deleteBook(@PathVariable Long personId) {
        Person personToDelete = personDao.findById(personId);
        personDao.delete(personToDelete);
    }

}
