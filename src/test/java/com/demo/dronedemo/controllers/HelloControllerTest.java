package com.demo.dronedemo.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldReturnHelloWorldAsDefault() throws Exception {
        mvc.perform(get("/hello").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.msg", is("Hello world")));
    }

    @Test
    public void shouldReturnHelloWithMessage() throws Exception {
        mvc.perform(get("/hello/world").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.msg", is("Hello world")));
    }
}