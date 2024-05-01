package hello.config

import com.zaxxer.hikari.HikariDataSource
import hello.support.logging.getLogger
import org.springframework.context.annotation.Bean
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.support.JdbcTransactionManager
import org.springframework.transaction.TransactionManager
import javax.sql.DataSource

//@Configuration // 주석 처리
class DbConfig {

    private val logger = getLogger(javaClass)

    @Bean
    fun dataSource(): DataSource {
        logger.info { "dataSource 빈 등록" }
        val dataSource = HikariDataSource()
        dataSource.driverClassName = "org.h2.Driver"
        dataSource.jdbcUrl = "jdbc:h2:mem:test"
        dataSource.username = "sa"
        dataSource.password = ""
        return dataSource
    }

    @Bean
    fun transactionManager(): TransactionManager {
        logger.info { "transactionManager 빈 등록" }
        return JdbcTransactionManager(dataSource())
    }

    @Bean
    fun namedParameterJdbcTemplate(): NamedParameterJdbcTemplate {
        logger.info { "jdbcTemplate 빈 등록" }
        return NamedParameterJdbcTemplate(dataSource())
    }
}
