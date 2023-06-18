package com.github.tywinlanni.chaibezsite.service

import com.github.tywinlanni.chaibezsite.model.postgres.Customer
import org.springframework.stereotype.Service

@Service
class CustomerService : CustomService() {

    fun findByEmailAndPassword(email: String, password: String) =
        customerDao.findByEmailAndPassword(email, password)

    fun getAll() = customerDao.findAll()

    fun create(customer: Customer) = customerDao.create(customer)

    fun getById(id: Long) = customerDao.findByPrimaryKey(id).get()
}
