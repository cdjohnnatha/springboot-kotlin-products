package com.dstore.product.exception

data class ErrorResponse (
    val message: String,
    val errors: List<ErrorDetail>,
)