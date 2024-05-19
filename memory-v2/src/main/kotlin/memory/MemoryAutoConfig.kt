package memory

import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean


@AutoConfiguration
@ConditionalOnProperty(name = ["memory"],havingValue = "on")
open class MemoryAutoConfig {

    @Bean
    open fun memoryController(): MemoryController {
        return MemoryController(memoryFinder())
    }

    @Bean
    open fun memoryFinder(): MemoryFinder {
        return MemoryFinder()
    }
}
