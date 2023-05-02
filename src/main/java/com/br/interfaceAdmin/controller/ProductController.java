package com.br.interfaceAdmin.controller;

import com.br.interfaceAdmin.model.entity.Product;
import com.br.interfaceAdmin.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("api/product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public @ResponseBody List<Product> list(){
        return productService.list();
    }

    @GetMapping(value = "/{id}")
    public Product findById(@PathVariable @NotNull @Positive Long id){
        return productService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Product save(@RequestBody @Valid Product product){
        return productService.save(product);
    }

    @PutMapping(value = "/id/{id}")
    public Product update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid Product product){
        return productService.update(id, product);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id){
        productService.delete(id);
    }
}
