package com.dstore.product.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.PositiveOrZero

data class ProductRequestDTO (
    @field:NotBlank(message = "Product ID cannot be blank")
    val name: String,

    @field:PositiveOrZero(message = "Product price must be greater than 0")
    val price: Double,

    val imagePath: String?,
    val description: String?
)