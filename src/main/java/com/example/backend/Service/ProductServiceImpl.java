package com.example.backend.Service;

import com.example.backend.Interface.ProductService;
import com.example.backend.Model.Product;
import com.example.backend.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {

        return productRepository.save(product);

    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Long id, Product product) {


        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
       productRepository.deleteById(id);
    }
}
