package com.postgresql.postgresqldemo.controller;

import com.postgresql.postgresqldemo.model.School;
import com.postgresql.postgresqldemo.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class schoolcontroller {


    private SchoolService service;

    @Autowired
    public schoolcontroller(SchoolService service){
        this.service = service;
    }


    @GetMapping("/student")
    public ResponseEntity<List<School>> getAllStudent(){
        List<School>  student = service.findAll();
        if(student.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(student);
    }

    @PostMapping("/getbyid/{id}")
    public Optional<School> searchBYid(@PathVariable Long id){
        return service.getbyid(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<School> updateStudent(@PathVariable Long id,@RequestBody School student){
        School upstudent = service.update(id,student);
        return ResponseEntity.ok(upstudent);
    }

    @PostMapping("/save")
    public ResponseEntity<School> addStudnet(@RequestBody School school){
        School student = service.create(school);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudnet(@PathVariable Long id){
        service.deleteStudent(id);
        return ResponseEntity.ok("student deleted");
    }
}
