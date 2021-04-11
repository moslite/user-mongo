package com.udemy.usermongo.resources;

import com.udemy.usermongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User user = new User("1", "Murilo", "moslite@gmail.com");
        User user2 = new User("2", "Barbara", "tina@gmail.com");
        List<User> userList = new ArrayList<>();
        userList.addAll(Arrays.asList(user, user2));
        return ResponseEntity.ok().body(userList);
    }

}
