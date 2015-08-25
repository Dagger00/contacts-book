package com.springapp.mvc.ajax;

import com.springapp.mvc.repository.UserRepository;
import com.springapp.mvc.repository.UserTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zenet_000 on 8/24/2015.
 */
@Controller
@Scope("request")
@RequestMapping(value = "/users")
public class AjaxController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody String getUsersJson() {
        JSONArray jsonArray = new JSONArray();
        List<UserTO> listWithUsers = userRepository.getUsers();
        for(UserTO user : listWithUsers){
            JSONObject user1 = new JSONObject();
            JSONArray contacts1 = new JSONArray();
            JSONObject contact = new JSONObject();
            contact.put("type", "phone");
            contact.put("value", "79152535695");
            contacts1.add(contact);
            user1.put("firstName", user.getFirstName());
            user1.put("lastName", user.getLastName());
            user1.put("contacts", contacts1);
            jsonArray.add(user1);
        }

        return jsonArray.toJSONString();
/*
        JSONArray list = new JSONArray();

        JSONObject user1 = new JSONObject();
        JSONArray contacts1 = new JSONArray();
        JSONObject contact = new JSONObject();
        contact.put("type", "phone");
        contact.put("value", "79152535695");
        contacts1.add(contact);
        user1.put("firstName", "Dmitry");
        user1.put("lastName", "Dorofeev");
        user1.put("contacts", contacts1);

        JSONObject user2 = new JSONObject();
        user2.put("firstName", "Sanyok");
        user2.put("lastName", "Zhurbean");
        user2.put("contacts", contacts1);

        JSONObject user3 = new JSONObject();
        user3.put("firstName", "Georgiy");
        user3.put("lastName", "Borisenko");
        user3.put("contacts", contacts1);

        list.add(user1);
        list.add(user2);
        list.add(user3);
        return list.toJSONString();
*/
    }
}
