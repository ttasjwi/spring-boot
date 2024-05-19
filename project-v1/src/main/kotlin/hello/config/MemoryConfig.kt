package hello.config

import memory.MemoryController
import memory.MemoryFinder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class MemoryConfig {
    @Bean
    fun memoryFinder(): MemoryFinder {
        return MemoryFinder()
    }

    @Bean
    fun memoryController(): MemoryController {
        return MemoryController(memoryFinder())
    }
}
