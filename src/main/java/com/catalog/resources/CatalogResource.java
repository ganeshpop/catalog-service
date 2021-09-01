package com.catalog.resources;


import com.catalog.bean.Product;
import com.catalog.bean.ProductList;
import com.catalog.service.CatalogServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping(path = "/products")
public class CatalogResource {

    private CatalogServiceInterface catalogService;

    @Autowired
    public void setCatalogService(CatalogServiceInterface catalogService) {
        this.catalogService = catalogService;
    }


    @GetMapping(produces = "Application/json")
    ProductList listAllProducts() {
        return catalogService.getAllProducts();
    }


    @GetMapping(path = "/{id}", produces = "Application/json")
    Product getProductById(@PathVariable("id") int id) {
        return catalogService.getProductById(id);
    }
    @GetMapping(path = "/code/{code}", produces = "Application/json")
    Product getProductByCode(@PathVariable("code") String code) {
        return catalogService.getProductByCode(code);
    }

    @PostMapping(produces = "Application/json", consumes = "Application/json")
    Product saveProduct(@RequestBody Product product) {
        return catalogService.insertProduct(product);
    }

    @DeleteMapping(path = "/{id}", produces = "Application/json")
    Product deleteProduct(@PathVariable("id") int id) {
        return catalogService.deleteProductById(id);
    }


    @PutMapping(path = "/{id}/{price}", produces = "Application/json")
    Product updateProductPrice(@PathVariable("id") int id, @PathVariable("price") Double price) {
        return catalogService.updateProductPrice(id, price);
    }
}