package hello.container

import hello.servlet.HelloServlet
import jakarta.servlet.ServletContext
import jakarta.servlet.ServletRegistration

class AppInitV1Servlet : AppInit {

    override fun onStartup(servletContext: ServletContext) {
        println("AppInitV1Servlet.onStartup")

        // 순수 서블릿 코드 등록
        val helloServlet: ServletRegistration.Dynamic = servletContext.addServlet("helloServlet", HelloServlet())
        helloServlet.addMapping("/hello-servlet")
    }
}
