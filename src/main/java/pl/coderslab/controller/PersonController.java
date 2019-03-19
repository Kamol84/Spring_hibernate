package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/form")
    public String form(@ModelAttribute Person person){
        personDao.save(person);
        return "person/details";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id){
        model.addAttribute("person", personDao.findById(id));
        return "person/form";
    }

    @PostMapping("/edit/{id}")
    public  String edit(@ModelAttribute Person person, @PathVariable String id){
        personDao.save(person);
        return "person/details";
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
