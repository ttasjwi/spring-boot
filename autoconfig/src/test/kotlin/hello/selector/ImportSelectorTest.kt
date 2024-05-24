package hello.selector

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

class ImportSelectorTest {

    @Test
    @DisplayName("정적 방식 Import 테스트")
    fun staticConfigTest() {
        val context = AnnotationConfigApplicationContext(StaticConfig::class.java)
        val bean = context.getBean(HelloBean::class.java)
        assertThat(bean).isNotNull
    }

    @Test
    @DisplayName("Selector 방식 Import 테스트")
    fun selectorConfigTest() {
        val context = AnnotationConfigApplicationContext(SelectorConfig::class.java)
        val bean = context.getBean(HelloBean::class.java)
        assertThat(bean).isNotNull
    }

    @Configuration
    @Import(HelloConfig::class)
    class StaticConfig

    @Configuration
    @Import(HelloImportSelector::class)
    class SelectorConfig
}
