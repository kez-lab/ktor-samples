val ktor_version: String by project
val kotlin_version: String by project
val opentelemetry_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm") version "1.9.21"
    id("io.ktor.plugin") version "2.3.9"
    id("application")
}

application {
    mainClass.set("opentelemetry.ktor.example.ServerKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

dependencies {
    implementation(project(":shared"))

    implementation("io.ktor:ktor-server-cio-jvm")
    implementation("io.ktor:ktor-server-websockets:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")

    implementation("io.opentelemetry.instrumentation:opentelemetry-ktor-2.0:$opentelemetry_version-alpha")
}