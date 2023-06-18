package com.github.tywinlanni.chaibezsite.controller

import com.github.tywinlanni.chaibezsite.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.transaction.annotation.Transactional
import org.springframework.validation.annotation.Validated

@Controller
@Validated
@Transactional
class CustomController {

    @Autowired
    protected lateinit var customerService: CustomerService
}
