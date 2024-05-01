package hello.config

import memory.MemoryCondition
import memory.MemoryController
import memory.MemoryFinder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Conditional
import org.springframework.context.annotation.Configuration

@Configuration
@Conditional(MemoryCondition::class) // 추가
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
