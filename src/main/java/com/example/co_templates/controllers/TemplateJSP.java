package com.example.co_templates.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TemplateJSP {

    @GetMapping("/templateWithJSP")
    public ModelAndView templateWithJSP(){
        String viewPath = "/WEB-INF/views/template.jsp";
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewPath);

        return modelAndView;
    }
}
