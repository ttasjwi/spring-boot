import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.5"
    id("io.spring.dependency-management") version "1.1.4"
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
    implementation("org.springframework:spring-webmvc")

    // 내장 톰캣
    implementation("org.apache.tomcat.embed:tomcat-embed-core")

    // json 처리
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // spring boot
    implementation("org.springframework.boot:spring-boot")
    implementation("org.springframework.boot:spring-boot-autoconfigure")

    // log 관련
    implementation("ch.qos.logback:logback-classic")
    implementation("org.apache.logging.log4j:log4j-to-slf4j")
    implementation("org.slf4j:jul-to-slf4j")

    // yaml 관련
    implementation("org.yaml:snakeyaml")

    // kotlin reflect
    implementation("org.jetbrains.kotlin:kotlin-reflect")
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
