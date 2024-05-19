package memory

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MemoryController(
    private val memoryFinder: MemoryFinder
) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/memory")
    fun system(): Memory {
        val memory = memoryFinder.get()

        logger.info ("memory = {}", memory)
        return memory
    }
}
