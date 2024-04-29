package hello.boot

import org.springframework.context.annotation.ComponentScan

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@ComponentScan
annotation class MySpringBootApplication
