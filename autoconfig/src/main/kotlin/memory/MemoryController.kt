package memory

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import support.logging.getLogger

@RestController
class MemoryController(
    private val memoryFinder: MemoryFinder
) {

    private val logger = getLogger(javaClass)

    @GetMapping("/memory")
    fun system(): Memory {
        val memory = memoryFinder.get()

        logger.info { "memory = $memory" }
        return memory
    }
}
