package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
@RequestMapping("/test")
public class ValidationController {


    @Autowired
    Validator validator;


    @GetMapping("/validate")
    @ResponseBody
    public String validate() {

        Book book = new Book();

        StringBuilder stringBuilder = new StringBuilder();
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        if (!violations.isEmpty()){
            for (ConstraintViolation<Book> err: violations){
                stringBuilder
                        .append(err.getPropertyPath())
                        .append("-")
                        .append(err.getMessage())
                        .append("<br>");
            }
        }

            return stringBuilder.toString();
    }
}

