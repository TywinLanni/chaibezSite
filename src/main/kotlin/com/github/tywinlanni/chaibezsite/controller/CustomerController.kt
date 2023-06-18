package com.github.tywinlanni.chaibezsite.controller

import com.github.tywinlanni.chaibezsite.model.postgres.Customer
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/api")
class CustomerController : CustomController() {

    @PostMapping("/customer")
    fun create(@RequestBody customer: Customer): ResponseEntity<String> {
        customerService.create(customer)
        return ResponseEntity
            .created(URI("/api/customer/${customer.id}"))
            .build()
    }

    @GetMapping("/customer/{id}")
    fun getCustomerById(
        @PathVariable(name = "id", required = true) id: Long
    ): ResponseEntity<Customer> =
        ResponseEntity
            .ok()
            .body(customerService.getById(id))

    @GetMapping("/customer")
    fun findByEmailAndPassword(email: String, password: String) =
        customerService.findByEmailAndPassword(email, password)

    @GetMapping("/customers")
    fun getAll(): ResponseEntity<List<Customer>> =
        ResponseEntity
            .ok()
            .body(customerService.getAll())
}
