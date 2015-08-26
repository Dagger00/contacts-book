package com.springapp.mvc.ajax;

import com.springapp.mvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zenet_000 on 8/24/2015.
 */
@Controller
@Scope("request")
@RequestMapping(value = "/users")
public class AjaxUserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addUser(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        userRepository.addUser(firstName, lastName);
    }

    @RequestMapping(value = "/{userID}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable int userID) {
        userRepository.deleteUser(userID);
    }
}
