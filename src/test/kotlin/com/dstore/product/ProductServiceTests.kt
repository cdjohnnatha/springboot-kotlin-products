package com.dstore.product

import com.dstore.product.model.Product
import com.dstore.product.repository.ProductRepository
import com.dstore.product.service.ProductService
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import java.util.Optional
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

@SpringBootTest
class ProductServiceTests {
	private val productRepository: ProductRepository = mockk()
	private val productService = ProductService(productRepository)

	@Nested
	@DisplayName("/api/v1/products")
	inner class ProductsApiTest {

		@Nested
		@DisplayName("GET All /products")
		inner class GetAllProducts {
			@Test
			fun `should return a list of products`() {
				val products = listOf(
					Product(1, null, "TEST_PATH_1", "TEST_PRODUCT_1", 1.0),
					Product(2, null, "TEST_PATH_2", "TEST_PRODUCT_2", 2.0),
				);

				every { productRepository.findAll() } returns products

				val result = productService.all();
				assert(result.size == 2);
			}

			@Nested
			@DisplayName("and when is empty")
			inner class WhenProductsIsEmpty {
				@Test
				fun `should return an empty array of products`() {

					every { productRepository.findAll() } returns emptyList();

					val result = productService.all();
					assert(result.isEmpty());
				}
			}
		}

		@Nested
		@DisplayName("GET single product /products/1")
		inner class GetSingleProduct {
			fun `should return a single product`(){
				val singleProduct = Product(1, null, "TEST_PATH_1", "TEST_PRODUCT_1", 1.0);

				every { productRepository.findById(1) } returns Optional.of(singleProduct);

				val result = productService.findById(1);

				assertNotNull(result);
				assertEquals(1, result.id);
				assertEquals("TEST_PATH_1", result.name);
				assertEquals("TEST_PRODUCT_1", result.description);
			}

			@Nested
			@DisplayName("When GET single product has wrong ID /products/-1")
			inner class WhenGetSingleProductHasWrongId {
				fun `should return a not found`() {
					val singleProduct = Product(1, null, "TEST_PATH_1", "TEST_PRODUCT_1", 1.0);

					every { productRepository.findById(1) } returns Optional.of(singleProduct);

					val result = productService.findById(-1);
					assertNull(result);
				}
			}
		}
	}
}
