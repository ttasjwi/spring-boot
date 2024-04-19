package hello.container

import jakarta.servlet.ServletContainerInitializer
import jakarta.servlet.ServletContext
import jakarta.servlet.annotation.HandlesTypes

@HandlesTypes(AppInit::class)
class MyContainerInitV2 : ServletContainerInitializer {

    override fun onStartup(classes: MutableSet<Class<*>>?, context: ServletContext?) {
        println("MyContainerInitV2.onStartUp")
        println("MyContainerInitV2 classes = $classes")
        println("MyContainerInitV2 context = $context")

        if (classes == null || context == null) {
            return
        }

        for (appInitClass in classes) {
            try {
                val appInit = appInitClass.getDeclaredConstructor().newInstance() as AppInit
                appInit.onStartup(context)
            } catch (e: Exception) {
                throw RuntimeException(e)
            }
        }
    }
}
