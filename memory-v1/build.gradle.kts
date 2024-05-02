import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.9.23"
}

group = "memory"

repositories {
    mavenCentral()
}

dependencies {
    // starter-web
    implementation("org.springframework.boot:spring-boot-starter-web:3.2.5")

    // json 처리
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.15.4")

    // kotlin reflect
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.9.23")

    // kotlin logging
    implementation("io.github.oshai:kotlin-logging:6.0.3")

    // test
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.2.5")
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
