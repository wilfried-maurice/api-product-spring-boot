package com.example.stock.Service;

import com.example.stock.Entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface ProductService {

    // Method for addProduct
    public Product addProduct(Product product);
     // Mehod for Edit Product
    public Product editProduct(Product product);

    // Method for delete Product
    void deleteProduct(Long id);

    // Method for Filters ProductLIst
    Page<Product> getRequestFilters(int page, int limit, String productName, Sort.Direction sortType);
}
