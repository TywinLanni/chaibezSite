package com.github.tywinlanni.chaibezsite.model.postgres

import jakarta.persistence.*

@Entity
@Table(name = "customer", schema = "public")
data class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column(name = "user_name", unique = true, nullable = false)
    val name: String,
    @Column(name = "user_password", nullable = false)
    val password: String,
    @Column(name = "user_email", unique = true, nullable = false)
    val email: String,
    @Column(name = "mongo_id", unique = true)
    val mongoId: String? = null,
)
