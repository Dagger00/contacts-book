package com.springapp.mvc.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * Created by zenet_000 on 8/24/2015.
 */
public interface UserRepository {
    List<UserTO> getUsers();
}
