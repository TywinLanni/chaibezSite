package com.github.tywinlanni.chaibezsite.dao.postgres

import com.github.tywinlanni.chaibezsite.model.postgres.Customer
import org.springframework.stereotype.Repository

@Repository
class CustomerDao : EntityDao<Customer, Long>() {

    override var entity: Class<Customer>? = Customer::class.java

    fun findByEmailAndPassword(email: String, password: String): Customer? {
        val criteriaBuilder = getCriteriaBuilder()
        val criteriaQuery = getCriteriaQuery()
        val root = criteriaQuery.from(entity)

        val query =
            criteriaQuery
                .select(root)
                .where(
                    criteriaBuilder.and(
                        criteriaBuilder.equal(root.get<String>("email"), email),
                        criteriaBuilder.equal(root.get<String>("password"), password),
                    )
                )

        return getQuery(query).singleResult
    }
}
