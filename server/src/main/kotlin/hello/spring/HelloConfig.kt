package hello.spring

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class HelloConfig {

    @Bean
    fun helloController(): HelloController {
        return HelloController()
    }
}
