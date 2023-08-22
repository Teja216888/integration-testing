package com.example.testdemo2;

import com.example.testdemo2.entity.Person;
import com.example.testdemo2.repository.PersonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
public class PersonIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    PersonRepository personRepository;


    @Test
    void givenBook_whenAddBook_thenReturnBook() throws Exception {
        Person book=new Person();
        book.setPersonName("teja");
        String bookJson=new ObjectMapper().writeValueAsString(book);
        MvcResult result= mockMvc.perform(post("/addperson").contentType(MediaType.APPLICATION_JSON).content(bookJson)).andReturn();
                //.andReturn();
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$").exists())
//                .andExpect(jsonPath("$.personId").value(1))
//                .andExpect(jsonPath("$.personName").value("teja"));
        System.out.println("result: "+result.getResponse().getContentAsString());

    }
}
