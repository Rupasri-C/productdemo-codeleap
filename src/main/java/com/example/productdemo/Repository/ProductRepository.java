package com.example.productdemo.Repository;

import com.example.productdemo.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface ProductRepository extends JpaRepository<Product,Integer>{

    }

