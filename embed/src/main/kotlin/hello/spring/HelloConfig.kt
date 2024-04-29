package hello.spring

import org.springframework.context.annotation.Bean

//@Configuration
class HelloConfig {

    @Bean
    fun helloController(): HelloController {
        return HelloController()
    }
}
