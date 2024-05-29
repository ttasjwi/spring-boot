package hello.exteranal

import org.springframework.boot.DefaultApplicationArguments


fun main(args: Array<String>) {
    for (arg in args) {
        println("arg $arg")
    }

    val appArgs = DefaultApplicationArguments(*args)

    println("sourceArgs = ${appArgs.sourceArgs.contentToString()}")
    println("NonOptionArgs = ${appArgs.nonOptionArgs}")
    println("OptionNames = ${appArgs.optionNames}")

    val optionNames = appArgs.optionNames
    for (optionName in optionNames) {
        println("option args $optionName = ${appArgs.getOptionValues(optionName)}")
    }

    val url = appArgs.getOptionValues("url")
    val username = appArgs.getOptionValues("username")
    val password = appArgs.getOptionValues("password")
    val mode = appArgs.getOptionValues("mode")
    println("url=$url")
    println("username=${username}")
    println("password=$password")
    println("mode=${mode}")
}
