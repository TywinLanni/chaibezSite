package com.github.tywinlanni.chaibezsite.service

import com.github.tywinlanni.chaibezsite.dao.postgres.CustomerDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
abstract class CustomService {

    @Autowired
    protected lateinit var customerDao: CustomerDao
}
