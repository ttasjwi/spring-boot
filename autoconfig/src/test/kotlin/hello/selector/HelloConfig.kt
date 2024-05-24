package hello.selector

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class HelloConfig {

    @Bean
    fun helloBean(): HelloBean {
        return HelloBean()
    }
}
