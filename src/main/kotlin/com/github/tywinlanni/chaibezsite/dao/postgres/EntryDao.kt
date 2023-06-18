package com.github.tywinlanni.chaibezsite.dao.postgres

import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import jakarta.persistence.TypedQuery
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.CriteriaQuery
import org.springframework.stereotype.Repository
import java.io.Serializable
import java.util.*

@Repository
abstract class EntityDao<T : Any, KEY : Serializable?> {

    @PersistenceContext
    protected lateinit var entityManager: EntityManager

    protected var entity : Class<T>? = null

    fun findByPrimaryKey(key: KEY): Optional<T> {
        return Optional.of(entityManager.find(entity, key))
    }

    fun findAll(): List<T> {
        val criteriaQuery = getCriteriaQuery()
        val root =  criteriaQuery.from(entity)
        val resultQuery = getQuery(criteriaQuery.select(root))

        return resultQuery.resultList
    }

    fun create(entity: T) : T {
        entityManager.persist(entity)

        return entity
    }

    fun update(entity: T) : T {
        return entityManager.merge(entity)
    }

    fun delete(entity: T) : T {
        entityManager.remove(entity)

        return entity
    }

    protected fun getCriteriaBuilder(): CriteriaBuilder {
        return entityManager.criteriaBuilder
    }

    protected fun getCriteriaQuery(): CriteriaQuery<T> {
        return entityManager.criteriaBuilder.createQuery(entity)
    }

    protected fun getQuery(criteriaQuery : CriteriaQuery<T>): TypedQuery<T> {
        return entityManager.createQuery(criteriaQuery)
    }

}