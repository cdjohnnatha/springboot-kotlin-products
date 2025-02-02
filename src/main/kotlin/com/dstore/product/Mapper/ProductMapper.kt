package com.dstore.product.Mapper

import com.dstore.product.dto.ProductRequestDTO
import com.dstore.product.model.Product

class ProductMapper {
    fun ConvertProductRequestDTOToProduct(productRequest: ProductRequestDTO): Product {
        return Product(null, null, productRequest.imagePath, productRequest.description, productRequest.price)
    }
}