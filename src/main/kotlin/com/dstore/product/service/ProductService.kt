package com.dstore.product.service

import com.dstore.product.model.Product
import com.dstore.product.repository.ProductRepository
import org.springframework.stereotype.Component

@Component
class ProductService(private val productRepository: ProductRepository) {
    fun all(): List<Product> {
        return productRepository.findAll().toList();
    }

    fun deleteById(id: Long) {
        productRepository.deleteById(id);
    }

    fun save(product: Product): Product {
        return productRepository.save(product);
    }

    fun update(id: Long, product: Product): Product {
        if (!productRepository.existsById(id)) throw RuntimeException("Product with id $id not found");

        return productRepository.save(product.copy(id = id));
    }

    fun findById(id: Long): Product {
        return productRepository.findById(id).orElseThrow { RuntimeException("Product not found") };
    }

    fun findByName(productName: String): List<Product> {
        return productRepository.queryByName(productName);
    }
}