package hello.exteranal

fun main() {
    // os 환경변수
    val envMap = System.getenv()
    for ((key, value) in envMap) {
        println("env $key: $value")
    }
}
