package com.example.SpringBootApp.service;

import com.example.SpringBootApp.entity.Product;
import com.example.SpringBootApp.repository.Productrepo;
import com.fasterxml.jackson.annotation.OptBoolean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final Productrepo productrepo;

    @Autowired
    public ProductService(Productrepo productrepo ){
        this.productrepo= productrepo;
    }

    public Product saveProduct(Product product){
        return productrepo.save(product);
    }

    public List<Product> getProduct(){
        return productrepo.findAll();
    }

    public Optional<Product> getById(Long Id){
        return productrepo.findById(Id);
    }

    public Product updateProduct(Long id,Product updateproduct) {
        Optional<Product> existingproduct = productrepo.findById(id);
        if (existingproduct.isPresent()) {
            Product product = existingproduct.get();
            product.setName(updateproduct.getName());
            product.setPrice(updateproduct.getPrice());
            product.setQuantity(updateproduct.getQuantity());

            return productrepo.save(product);
        } else{
            throw new RuntimeException("product not found");
        }
    }

    public void delateProduct(Long id){
        productrepo.deleteById(id);
    }

}
