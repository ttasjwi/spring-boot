package memory

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MemoryController(
    private val memoryFinder: MemoryFinder
) {

    private val logger = KotlinLogging.logger(javaClass.name)

    @GetMapping("/memory")
    fun system(): Memory {
        val memory = memoryFinder.get()

        logger.info { "memory = $memory" }
        return memory
    }
}
