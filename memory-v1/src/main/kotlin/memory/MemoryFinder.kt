package memory

import io.github.oshai.kotlinlogging.KotlinLogging
import jakarta.annotation.PostConstruct

class MemoryFinder {

    private val logger = KotlinLogging.logger(javaClass.name)

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
