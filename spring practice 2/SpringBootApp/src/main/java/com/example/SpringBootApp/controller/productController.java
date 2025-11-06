package com.example.SpringBootApp.controller;

import com.example.SpringBootApp.entity.Product;
import com.example.SpringBootApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class productController {

    private final ProductService productService;

    @Autowired
    public productController(ProductService productService){
        this.productService=productService;
    }


    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product newproduct = productService.saveProduct(product);
        return ResponseEntity.ok(newproduct) ;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> products= productService.getProduct();
        if(products.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

    @PostMapping("product/{id}")
    public Optional<Product> getbyid(@PathVariable Long id){
        return productService.getById(id);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id,@RequestBody Product product){
        Product updateproduct = productService.updateProduct(id,product);
        return ResponseEntity.ok(updateproduct);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteproduct(@PathVariable Long id){
        productService.delateProduct(id);
        return ResponseEntity.ok("product deleted");

    }

}
