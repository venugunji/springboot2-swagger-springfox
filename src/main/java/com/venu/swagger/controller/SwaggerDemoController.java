package com.venu.swagger.controller;

import com.venu.swagger.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwaggerDemoController {

  @GetMapping(value = "/getuser")
  public User getUserInfo() {
    return new User("Venu", "Scottsdale");
  }

  @PostMapping(value = "/postuser", consumes = "application/json")
  public User postUser(@RequestBody User user) {
    return user;
  }
}
