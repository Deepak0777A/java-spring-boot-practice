package com.postgresql.postgresqldemo.service;

import com.postgresql.postgresqldemo.model.School;
import com.postgresql.postgresqldemo.repository.SchoolRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {

    private SchoolRepo schoolrepo;

    @Autowired
    public SchoolService(SchoolRepo schoolrepo){
        this.schoolrepo =schoolrepo;
    }

    public School create(School school){
        return schoolrepo.save(school);
    }

    public List<School> findAll(){
        return schoolrepo.findAll();
    }



    @Transactional
    public School update(Long id,School updatestudent){
        School studnet = schoolrepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        studnet.setName(updatestudent.getName());
        studnet.setAge((updatestudent.getAge()));

        return schoolrepo.save(studnet);
    }

    public Optional<School> getbyid(Long id){
        Optional<School> student = schoolrepo.findById(id);
        return student;
    }

    public void deleteStudent(Long id){
        schoolrepo.deleteById(id);
    }


}
