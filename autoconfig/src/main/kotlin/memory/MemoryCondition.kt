package memory

import org.springframework.context.annotation.Condition
import org.springframework.context.annotation.ConditionContext
import org.springframework.core.type.AnnotatedTypeMetadata
import support.logging.getLogger

class MemoryCondition : Condition {

    private val logger = getLogger(javaClass)


    override fun matches(context: ConditionContext, metadata: AnnotatedTypeMetadata): Boolean {
        val memory: String? = context.environment.getProperty("memory")

        logger.info { "memory = $memory" }

        return "on" == memory
    }

}
