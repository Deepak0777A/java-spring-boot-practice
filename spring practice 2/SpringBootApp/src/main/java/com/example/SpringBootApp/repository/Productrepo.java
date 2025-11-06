package com.example.SpringBootApp.repository;

import com.example.SpringBootApp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Productrepo extends JpaRepository<Product, Long> {

}
