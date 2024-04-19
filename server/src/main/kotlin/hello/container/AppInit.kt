package hello.container

import jakarta.servlet.ServletContext

interface AppInit {

    fun onStartup(servletContext: ServletContext)
}
