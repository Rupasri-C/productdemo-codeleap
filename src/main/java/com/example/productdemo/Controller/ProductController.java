package com.example.productdemo.Controller;

import com.example.productdemo.Model.Product;
import com.example.productdemo.Service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService=productService;
    }
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public Product GetProductById(@PathVariable int id){
        return productService.getProductById(id);
    }

    @PostMapping
    public Product addNewProduct(@RequestBody Product newProduct){
        return productService.addProduct(newProduct);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product updatedProduct)
    {
        return productService.updateProduct(id,updatedProduct);
    }
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable  int id){
        boolean result=productService.deleteProduct(id);
        if(result)
        {
            return "Product deleted successfully";
        }
        else {
            return "Product Not Found";
        }
    }

}