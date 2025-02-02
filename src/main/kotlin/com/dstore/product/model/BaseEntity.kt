package com.dstore.product.model

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseEntity {
    @CreatedDate
    @Column(updatable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    var createdAt: LocalDateTime = LocalDateTime.now();

    @LastModifiedDate
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    var updatedAt: LocalDateTime = LocalDateTime.now();
}