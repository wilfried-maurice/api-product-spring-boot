package com.example.stock.Controller;


import com.example.stock.Entities.Product;
import com.example.stock.Handlers.ProductHandlers;
import com.example.stock.Service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/add")
    public ResponseEntity<Object> addProduct(@RequestBody @Valid Product product) {
        try {
            Product addedProduct = productService.addProduct(product);
            return ProductHandlers.handleResponse("Save succes", HttpStatus.OK, addedProduct);
        } catch (Exception e) {
            return ProductHandlers.handleResponse("Error save", HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping(value = "/edit")
    public ResponseEntity<Object> editProduct(@RequestBody @Valid Product product) {
        try {
            Product editdProduct = productService.editProduct(product);
            if (editdProduct!=null){
                return ProductHandlers.handleResponse("Edit succes", HttpStatus.OK, editdProduct);
            } else {
                return ProductHandlers.handleResponse("Product id not exist", HttpStatus.BAD_REQUEST, null);
            }
        } catch (Exception e) {
            return ProductHandlers.handleResponse("Error edit", HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id) {
        try {
            productService.deleteProduct(id);
            return ProductHandlers.handleResponse("Delete succes", HttpStatus.OK, null);
        } catch (Exception e) {
            return ProductHandlers.handleResponse("Delete succes", HttpStatus.BAD_REQUEST, e.getMessage());

        }
    }

    @GetMapping
    public ResponseEntity<Object> getProducts(@RequestParam(required = false, defaultValue =  "0")int page,
                                              @RequestParam(required = false, defaultValue = "5") int limit,
                                              @RequestParam(required = false) String productName,
                                              @RequestParam(required = false) Sort.Direction sortType) {
        try {
            Page<Product> productPage = productService.getRequestFilters( page,  limit, productName, sortType);
            return ProductHandlers.handleResponse("Get product succes", HttpStatus.OK, productPage);
        } catch (Exception e) {

            return ProductHandlers.handleResponse("Error", HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


}
