package com.dstore.product.model

import jakarta.persistence.*
import org.jetbrains.annotations.NotNull
import java.util.UUID

@Entity
@Table(name = "products")
data class Product (
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?= null,
    val uuid: UUID? = UUID.randomUUID(),
    val imagePath: String? = null,
    @NotNull
    val name: String? = null,
    @NotNull
    val price: Double? = null,
    val description: String? = null,
): BaseEntity() {}