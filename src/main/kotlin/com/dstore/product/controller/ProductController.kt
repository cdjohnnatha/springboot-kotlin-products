package com.dstore.product.controller

import com.dstore.product.Mapper.ProductMapper
import com.dstore.product.dto.ProductRequestDTO
import com.dstore.product.exception.ErrorDetail
import com.dstore.product.exception.ErrorResponse
import com.dstore.product.model.Product
import com.dstore.product.service.ProductService
import jakarta.validation.Valid
import jakarta.validation.ValidationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/products")
class ProductController(private val service: ProductService) {

    val ProductMapper = ProductMapper()

    @GetMapping
    fun list(): ResponseEntity<List<Product>> {
        val products = service.all().toList();

        return ResponseEntity.ok(products);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid requestBody: ProductRequestDTO): ResponseEntity<Product> {
        val createdProduct = service.save(ProductMapper.ConvertProductRequestDTOToProduct(requestBody))

        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    };

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Product> {
        return ResponseEntity.ok(service.findById(id))
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody product: Product): ResponseEntity<Product> {
        val updatedProduct = service.update(id, product);

        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteById(@PathVariable id: Long) {
        service.deleteById(id);
    }

    @GetMapping("/search")
    fun findByName(@RequestParam name: String): List<Product>? {
        return service.findByName(name).orEmpty();
    }

    @GetMapping("/count")
    fun productsCount(): Map<String, Long> {
        val total = service.productsCount();
        return mapOf("totalProducts" to total);
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationExceptions(exception: MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {
        val errors = exception.bindingResult.allErrors.map { it as FieldError }
        val errorDetails = errors.map { ErrorDetail(it.field, it.defaultMessage ?: "Invalid value") }

        val errorResponse = ErrorResponse("Validation failed", errorDetails)
        return ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST)
    }
}