package com.springapp.mvc.ajax;

import com.springapp.mvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zenet_000 on 8/25/2015.
 */
@Controller
@Scope("request")
@RequestMapping(value = "/contacts")
public class AjaxContactController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addContact(@RequestParam("userID") int userID,
                           @RequestParam("typeID") int typeID,
                           @RequestParam("value") String value) {
        userRepository.addContact(userID, typeID, value);
    }

    @RequestMapping(value = "/{contactID}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteContact(@PathVariable int contactID) {
        userRepository.deleteContact(contactID);
    }
}
