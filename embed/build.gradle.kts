import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.9.23"

    // kotlin-spring allOpen 플러그인
    // 아래 어노테이션이 있을 경우 'open' 키워들을 붙여줌
    // @Component, @Async, @Transactional, @Cacheable, @SpringBootTest, @Configuration, @Controller, @RestController, @Service, @Repository, @Component
    id("org.jetbrains.kotlin.plugin.spring") version "1.9.23"
}

group = "hello"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // 스프링 mvc
    implementation("org.springframework:spring-webmvc:6.1.6")

    // 내장 톰캣 추가
    implementation("org.apache.tomcat.embed:tomcat-embed-core:10.1.20")
}

tasks {
    test {
        useJUnitPlatform()
    }

    withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs += "-Xjsr305=strict"
            jvmTarget = "21"
        }
    }

    task(name = "buildJar", type= Jar::class) {
        manifest {
            attributes["Main-Class"] = "hello.embed.EmbedTomcatSpringMainKt"
        }

        from(sourceSets.main.get().output)
    }

    task(name = "buildFatJar", type= Jar::class) {
        manifest {
            attributes["Main-Class"] = "hello.embed.EmbedTomcatSpringMainKt"
        }

        from(sourceSets.main.get().output)
        duplicatesStrategy = DuplicatesStrategy.WARN
        from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    }

}
