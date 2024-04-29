package hello.embed

import hello.servlet.HelloServlet
import org.apache.catalina.connector.Connector
import org.apache.catalina.startup.Tomcat
import java.io.File

class EmbedTomcatServletMain

fun main(args: Array<String>) {
    println("EmbedTomcatServletMain.main")

    // 내장 톰캣 생성 및 설정
    val tomcat = Tomcat()
    val connector = Connector()
    connector.port = 8080
    tomcat.connector = connector

    // 서블릿 등록
    val context = tomcat.addContext("", "/")

    var docBaseFile = File(context.docBase)
    if (!docBaseFile.isAbsolute) {
        docBaseFile = File((context.parent as org.apache.catalina.Host).appBaseFile, docBaseFile.path)
    }
    docBaseFile.mkdirs()

    tomcat.addServlet("", "helloServlet", HelloServlet())
    context.addServletMappingDecoded("/hello-servlet", "helloServlet")

    // 내장톰캣 시작
    tomcat.start()
}
