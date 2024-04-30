import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.5"
//    id("io.spring.dependency-management") version "1.1.4"
    id("org.jetbrains.kotlin.jvm") version "1.9.23"
    id("org.jetbrains.kotlin.plugin.spring") version "1.9.23"
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
    // web mvc
    implementation("org.springframework:spring-webmvc:6.1.6")

    // 내장 톰캣
    implementation("org.apache.tomcat.embed:tomcat-embed-core:10.1.20")

    // json 처리
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.15.4")

    // spring boot
    implementation("org.springframework.boot:spring-boot:3.2.5")
    implementation("org.springframework.boot:spring-boot-autoconfigure:3.2.5")

    // log 관련
    implementation("ch.qos.logback:logback-classic:1.4.14")
    implementation("org.apache.logging.log4j:log4j-to-slf4j:2.21.1")
    implementation("org.slf4j:jul-to-slf4j:2.0.13")

    // yaml 관련
    implementation("org.yaml:snakeyaml:2.2")

    // kotlin reflect
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.9.23")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "21"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
