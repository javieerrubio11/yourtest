package com.yourtest.config

import org.springframework.orm.jpa.JpaTransactionManager
import javax.persistence.EntityManagerFactory
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import java.beans.PropertyVetoException
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource


//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(basePackages = arrayOf("com.nouhoun.springboot.jwt.integration.repository"))
class DatasourceConfig {
//    @Bean
//    @Throws(PropertyVetoException::class)
//    fun datasource(): DataSource {
//        val builder = EmbeddedDatabaseBuilder()
//
//        return builder
//                .setType(EmbeddedDatabaseType.H2)
//                .addScript("sql-scripts/schema.sql")
//                .addScript("sql-scripts/data.sql")
//                .build()
//    }
//
//    @Bean
//    @Throws(PropertyVetoException::class)
//    fun entityManagerFactory(@Qualifier("datasource") ds: DataSource): LocalContainerEntityManagerFactoryBean {
//        val entityManagerFactory = LocalContainerEntityManagerFactoryBean()
//        entityManagerFactory.dataSource = ds
//        entityManagerFactory.setPackagesToScan(*arrayOf("com.nouhoun.springboot.jwt.integration.domain"))
//        val jpaVendorAdapter = HibernateJpaVendorAdapter()
//        entityManagerFactory.jpaVendorAdapter = jpaVendorAdapter
//        return entityManagerFactory
//    }
//
//    @Bean
//    fun transactionManager(entityManagerFactory: EntityManagerFactory): PlatformTransactionManager {
//        val transactionManager = JpaTransactionManager()
//        transactionManager.entityManagerFactory = entityManagerFactory
//        return transactionManager
//    }
}