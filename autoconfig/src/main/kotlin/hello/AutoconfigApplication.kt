package hello

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AutoconfigApplication

fun main(args: Array<String>) {
    runApplication<AutoconfigApplication>(*args)
}
