package memory

import jakarta.annotation.PostConstruct
import support.logging.getLogger

class MemoryFinder {

    private val logger = getLogger(javaClass)

    fun get(): Memory {
        val max = Runtime.getRuntime().maxMemory()
        val total = Runtime.getRuntime().totalMemory()
        val free = Runtime.getRuntime().freeMemory()
        val used = total - free

        return Memory(used, max)
    }

    @PostConstruct
    fun init() {
        logger.info { "init memoryFinder" }
    }
}
