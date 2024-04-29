package hello.boot

import org.apache.catalina.connector.Connector
import org.apache.catalina.startup.Tomcat
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet

class MySpringApplication {

    companion object {

        fun run(configClass: Class<*>, vararg args: String) {
            println("MySpringBootApplication.run args=${listOf(args)}")

            // 내장 톰캣 생성 및 설정
            val tomcat = Tomcat()
            val connector = Connector()
            connector.port = 8080
            tomcat.connector = connector

            // 스프링 컨테이너 생성
            val appContext = AnnotationConfigWebApplicationContext()
            appContext.register(configClass)

            // 스프링 MVC 디스패처 서블릿 생성, 스프링 컨테이너 연결
            val dispatcherServlet = DispatcherServlet(appContext)

            // 디스패처 서블릿 등록
            val context = tomcat.addContext("", "/")
            tomcat.addServlet("", "dispatcher", dispatcherServlet)
            context.addServletMappingDecoded("/", "dispatcher")

            // 내장톰캣 시작
            tomcat.start()
        }
    }
}

inline fun <reified T : Any> runApplication(vararg args: String) {
    MySpringApplication.run(T::class.java, *args)
}
