package com.springapp.mvc.controller;

import com.springapp.mvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zenet_000 on 8/23/2015.
 */
@Controller
@RequestMapping(value = "/")
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("index.jsp");
        model.addObject("list", userRepository.getUsers());
        model.addObject("types", userRepository.getTypes());
        return model;
    }
}
