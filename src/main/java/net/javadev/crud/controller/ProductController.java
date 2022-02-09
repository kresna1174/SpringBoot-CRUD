package net.javadev.crud.controller;

import net.javadev.crud.exception.ResourceNotFoundException;
import net.javadev.crud.model.Product;
import net.javadev.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getProduct () {
        return productRepository.findAll();
    }

    @PostMapping
    public Product store (@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("{id}")
    public  ResponseEntity<Product> edit (@PathVariable long id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product Doest Not Exist")
        );
        return ResponseEntity.ok(product);
    }

    @PutMapping("{id}")
    public  ResponseEntity<Product> update (@PathVariable long id, @RequestBody Product product) {
        Product updateProduct = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product Doest Not Exist")
        );
        updateProduct.setProductName(product.getProductName());
        updateProduct.setStock(product.getStock());
        updateProduct.setSupplier(product.getSupplier());
        return ResponseEntity.ok(updateProduct);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity<Product> delete (@PathVariable long id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product Doest Not Exist")
        );
        productRepository.delete(product);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
