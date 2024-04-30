package hello.boot.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @GetMapping("/hello-spring")
    fun hello(): String {
        println("HelloController.hello")
        return "hello spring!"
    }
}
