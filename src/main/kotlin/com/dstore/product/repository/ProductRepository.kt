package com.dstore.product.repository

import com.dstore.product.model.Product
import org.springframework.data.repository.CrudRepository

interface ProductRepository: CrudRepository<Product, Long> {
    fun queryByName(name: String): MutableList<Product>
}
