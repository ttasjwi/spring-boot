package hello

import hello.boot.MySpringBootApplication
import hello.boot.runApplication

@MySpringBootApplication
class MySpringBootMain

fun main(args: Array<String>) {
    runApplication<MySpringBootMain>(*args)
}
