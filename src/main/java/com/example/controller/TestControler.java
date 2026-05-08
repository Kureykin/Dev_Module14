package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TestControler {
    @GetMapping(value = "/test")
    public ModelAndView getTest() {
        return new ModelAndView("test/test");
    }
}