package hello.exteranal

fun main() {
    // 내부에서 프로퍼티 설정을 할 수도 있긴 함
    System.setProperty("hello_key", "hello_value")
    val helloValue = System.getProperty("hello_key")
    println("prop hello_key= $helloValue")
    println("===")

    val properties = System.getProperties()
    for (key in properties.keys) {
        println("prop $key = ${properties[key]}")
    }
    val url = System.getProperty("url")
    val username = System.getProperty("username")
    val password = System.getProperty("password")

    println("url: $url")
    println("username: $username")
    println("password: $password")
}
