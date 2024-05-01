package hello.config

import support.logging.getLogger
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.transaction.TransactionManager
import javax.sql.DataSource

@SpringBootTest
class DbConfigTest {

    private val logger = getLogger(javaClass)

    @Autowired
    lateinit var dataSource: DataSource

    @Autowired
    lateinit var transactionManager: TransactionManager

    @Autowired
    lateinit var namedParameterJdbcTemplate: NamedParameterJdbcTemplate

    @Test
    fun checkBean() {
        logger.info { "dataSource = $dataSource" }
        logger.info { "transactionManager = $transactionManager" }
        logger.info { "namedParameterJdbcTemplate = $namedParameterJdbcTemplate" }

        assertThat(dataSource).isNotNull
        assertThat(transactionManager).isNotNull
        assertThat(namedParameterJdbcTemplate).isNotNull
    }
}
