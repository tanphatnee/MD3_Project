package ra.controller;

import ra.model.Product;
 import ra.service.ProductService;

import java.util.List;

public class ProductController {
    private ProductService productService;
    public ProductController() {
        productService  = new ProductService();
    }

    public List<Product> findAll() {
        return productService.findAll();
    }


    public void save(Product product) {
        productService.save(product);
    }


    public void delete(int id) {
        productService.delete(id);
    }


    public Product findById(int id) {
        return productService.findById(id);
    }
    public int getNewId() {
        return productService.getNewId();
    }
}
