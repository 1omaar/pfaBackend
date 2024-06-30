package com.example.backend.Interface;


import com.example.backend.Model.Product;
import java.util.List;

public interface ProductService {
    Product createProduct(Product product);

    Product getProductById(Long id);

    List<Product> getAllProducts();

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);
    List<Product> searchProducts(String query); // Add this method

}

