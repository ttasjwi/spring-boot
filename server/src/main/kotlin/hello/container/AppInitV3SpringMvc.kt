package hello.container

import hello.spring.HelloConfig
import jakarta.servlet.ServletContext
import jakarta.servlet.ServletRegistration
import org.springframework.web.WebApplicationInitializer
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet


/**
 * http://localhost:8080/hello-spring
 */
class AppInitV3SpringMvc : WebApplicationInitializer {
    override fun onStartup(servletContext: ServletContext) {
        println("AppInitV3SpringMvc.onStartup")

        // 스프링 컨테이너 생성
        val appContext = AnnotationConfigWebApplicationContext()
        appContext.register(HelloConfig::class.java)

        // 스프링 MVC 디스페처 서블릿 생성, 스프링 컨테이너 연결
        val dispatcherServlet = DispatcherServlet(appContext)

        // 디스페처 서블릿을 서블릿 컨테이너에 등록 (이름 주의! dispatcherV3)
        val servletRegistration: ServletRegistration.Dynamic = servletContext.addServlet("dispatcherV3", dispatcherServlet)

        // 모든 요청이 디스페처 서블릿을 통하도록 설정
        servletRegistration.addMapping("/")
    }
}
