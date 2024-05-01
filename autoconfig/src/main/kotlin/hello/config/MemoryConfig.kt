package hello.config

import memory.MemoryController
import memory.MemoryFinder
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
//@Conditional(MemoryCondition::class) // 주석
@ConditionalOnProperty(name= ["memory"], havingValue = "on") // 추가
class MemoryConfig {

    @Bean
    fun memoryController(): MemoryController {
        return MemoryController(memoryFinder())
    }

    @Bean
    fun memoryFinder(): MemoryFinder {
        return MemoryFinder()
    }
}
