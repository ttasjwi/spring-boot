package hello.container

import hello.spring.HelloConfig
import jakarta.servlet.ServletContext
import jakarta.servlet.ServletRegistration
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet

/**
 * http://localhost:8080/spring/hello-spring
 */
class AppInitV2Spring : AppInit {

    override fun onStartup(servletContext: ServletContext) {
        println("AppInitV2Spring.onStartup")

        // 스프링 컨테이너 생성 및 설정 클래스 등록
        val appContext = AnnotationConfigWebApplicationContext()
        appContext.register(HelloConfig::class.java)

        // 스프링 MVC 디스패처 서블릿 생성, 스프링 컨테이너 연결
        val dispatcherServlet = DispatcherServlet(appContext)

        // 디스패처 서블릿을 서블릿 컨테이너에 등록 (이름 주의: dispatcherV2)
        val registration: ServletRegistration.Dynamic = servletContext.addServlet("dispatcherV2", dispatcherServlet)

        // /spring/* 요청이 디스페처 서블릿을 통하도록 설정
        registration.addMapping("/spring/*")
    }
}
