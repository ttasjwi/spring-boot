package memory

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MemoryFinderTest {

    @Test
    fun get() {
        val memoryFinder = MemoryFinder()
        val memory = memoryFinder.get()

        assertThat(memory).isNotNull
    }
}
