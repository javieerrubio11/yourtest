package com.yourtest.service

import org.springframework.stereotype.Service
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

class GeneralService () : IGeneralService {
    @PersistenceContext
    lateinit var entityManager: EntityManager


    override fun search(params: List<SearchCriteria>): List<Any> {
        val builder = entityManager.getCriteriaBuilder()
        val query = builder.createQuery(Any::class.java)
        val r = query.from(Any::class.java)

        var predicate = builder.conjunction()

        for (param in params) {
            if (param.operation.equals(">")) {
                predicate = builder.and(predicate, builder.greaterThanOrEqualTo(r.get(param.key), param.value.toString()))
            } else if (param.operation.equals("<")) {
                predicate = builder.and(predicate, builder.lessThanOrEqualTo(r.get(param.key), param.value.toString()))
            } else if (param.operation.equals(":")) {
                if(param.value is String)
                    predicate = builder.and(predicate, builder.like(r.get(param.key),"%" + param.value + "%"))
            }
        }

        query.where(predicate)
        return entityManager.createQuery(query).getResultList()
    }
}

class SearchCriteria (
    val key: String? = null,
    val operation: String? = null,
    val value: Any? = null
)