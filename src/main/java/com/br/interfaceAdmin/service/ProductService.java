package com.br.interfaceAdmin.service;

import com.br.interfaceAdmin.model.entity.Product;
import com.br.interfaceAdmin.model.repository.ProductRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> list(){
        return productRepository.findAll();
    }

    public Product findById(@NotNull @Positive Long id){
        return productRepository.findById(id).orElseThrow();
    }

    public Product save(@Valid Product product){
        return productRepository.save(product);
    }

    public Product update(@NotNull @Positive Long id, @Valid Product product){
        return productRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setDescription(product.getDescription());
                    return productRepository.save(recordFound);
                }).orElseThrow();
    }

    public void delete(@NotNull @Positive Long id){
        productRepository.delete(productRepository.findById(id).orElseThrow());
    }
}
