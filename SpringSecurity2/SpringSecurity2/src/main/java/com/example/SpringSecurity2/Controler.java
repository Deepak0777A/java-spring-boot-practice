package com.example.SpringSecurity2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controler {


    @Autowired
    private MyUserRepo myUserRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @PostMapping("/register/user")
    public MYUser adduser(@RequestBody MYUser user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return myUserRepo.save(user);
    }

    @GetMapping("/admin/home")
    public String adhome(){
        return "admin home";
    }

    @GetMapping("/user/home")
    public String home(){
        return "user home";
    }

}
