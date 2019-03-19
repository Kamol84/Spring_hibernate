package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

    @ModelAttribute("skills")
    public Collection<String> skills(){
        List<String > skills = new ArrayList<>();
        skills.add("Java");
        skills.add("Php");
        skills.add("python");
        skills.add("ruby");
        return skills;
    }

    @ModelAttribute("hobbieList")
    public Collection<String> hobbieList(){
        List<String > hobbieList = new ArrayList<>();
        hobbieList.add("Study");
        hobbieList.add("Girls");
        hobbieList.add("Drinking");
        hobbieList.add("Smoke");
        return hobbieList;
    }


    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("student", new Student());
        return "/student/form";
    }


    @PostMapping("/form")
    @ResponseBody
    public String form(@ModelAttribute Student student){
        return student.toString();
    }



}
