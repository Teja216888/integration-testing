package com.example.testdemo2.resource;

import com.example.testdemo2.entity.Person;

import com.example.testdemo2.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {
    @Autowired
    PersonRepository personRepository;

    @PostMapping("/addperson")
    public Person addPerson(@RequestBody Person person){
        return personRepository.save(person);
    }

    @GetMapping("/findAll")
    public List<Person> findAll(){
        List<Person> personList=new ArrayList<>();
        personRepository.findAll().forEach(person -> personList.add(person));
        return personList;
    }
}
