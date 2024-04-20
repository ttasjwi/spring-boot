import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.23"

    // kotlin-spring allOpen 플러그인
    // 아래 어노테이션이 있을 경우 'open' 키워들을 붙여줌
    // @Component, @Async, @Transactional, @Cacheable, @SpringBootTest, @Configuration, @Controller, @RestController, @Service, @Repository, @Component
    kotlin("plugin.spring") version "1.9.23"

    // war로 빌드
    id("war")
}

group = "hello"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
}

dependencies {
    // 서블릿
    implementation("jakarta.servlet:jakarta.servlet-api:6.0.0")

    // 스프링 mvc
    implementation("org.springframework:spring-webmvc:6.1.6")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "21"
    }
}

tasks.test {
    useJUnitPlatform()
}
