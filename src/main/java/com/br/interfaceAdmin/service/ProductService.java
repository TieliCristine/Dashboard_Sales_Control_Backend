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

    private List<Product> list(){
        return productRepository.findAll();
    }

    private Product findById(@NotNull @Positive Long id){
        return productRepository.findById(id).orElseThrow();
    }

    private Product save(@Valid Product product){
        return productRepository.save(product);
    }

    private Product update(@NotNull @Positive Long id, @Valid Product product){
        return productRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setDescription(product.getDescription());
                    return productRepository.save(recordFound);
                }).orElseThrow();
    }

    private void delete(@NotNull @Positive Long id){
        productRepository.delete(productRepository.findById(id).orElseThrow());
    }
}
