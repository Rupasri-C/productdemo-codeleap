package com.example.productdemo.Service;

import com.example.productdemo.Model.Product;
import com.example.productdemo.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository)
    {
        this.productRepository=productRepository;
    }

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(int id)
    {
        return productRepository.findById(id).orElse(null);
    }

    public Product updateProduct(Integer id, Product updatedProduct){
        Product existingProduct=productRepository.findById(id).orElse(null);
        if(existingProduct==null)
        {
            return null;
        }
        existingProduct.setProductName(updatedProduct.getProductName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setQuantity(updatedProduct.getQuantity());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setStock(updatedProduct.getStock());

        return   productRepository.save(existingProduct);

    }
    public boolean deleteProduct(int id){
        if(!productRepository.existsById(id)){
            return false;
        }
        productRepository.deleteById(id);
        return true;
    }
}