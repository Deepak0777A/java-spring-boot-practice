package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class demo {

    @GetMapping("")
    public String demomethod(){
        return "hi ";
    }
    @GetMapping("/about")
    public String aboutMe(){
        return " my name deepak my age is 21";
    }

    @GetMapping("/input")
    public String getInput(@RequestParam String name){  //?
        return "name : "+name;
    }

    @GetMapping("inputage")
    public String getAge(@RequestParam( defaultValue= "no name") String name){
        return "name : "+name;
    }

    @GetMapping("input/{name}")
    public String pathTestMethod(@PathVariable String name){
        return "your name : "+name;
    }



}
