package hello.container

import jakarta.servlet.ServletContainerInitializer
import jakarta.servlet.ServletContext

class MyContainerInitV1 : ServletContainerInitializer {

    override fun onStartup(classes: MutableSet<Class<*>>?, context: ServletContext?) {
        println("MyContainerInitV1.onStartUp")
        println("MyContainerInitV1 classes = $classes")
        println("MyContainerInitV context = $context")
    }
}
