package com.dstore.product

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class ProductApplication

fun main(args: Array<String>) {
	runApplication<ProductApplication>(*args)
}
