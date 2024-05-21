package hello

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProjectV2Application

fun main(args: Array<String>) {
	runApplication<ProjectV2Application>(*args)
}
