package com.dstore.product.repository

import com.dstore.product.model.Product
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product, Long> {

    @Query("SELECT * FROM products WHERE name=:name")
    fun queryByName(name: String): List<Product>

}
