import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.4.5"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.4.32"
    kotlin("plugin.spring") version "1.4.32"
}

group = "com.ecbx"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
    mavenLocal()
    maven {
        url = uri("https://app.camunda.com/nexus/content/groups/public")
    }

    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

dependencies {
//    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
//    testImplementation("org.springframework.boot:spring-boot-starter-test")

    implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter-webapp:7.15.0")
    implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter-rest:7.15.0")
    implementation("com.h2database:h2:1.4.200")
    implementation("org.springframework.boot:spring-boot-starter-jdbc:2.4.4")
    implementation("org.camunda.spin:camunda-spin-dataformat-all:1.10.1")
    implementation("org.camunda.bpm:camunda-engine-plugin-spin:7.15.0")
    runtimeOnly("javax.xml.bind:jaxb-api:2.3.1")
    testImplementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter-test:7.15.0")
    testImplementation("org.camunda.bpm.extension:camunda-bpm-process-test-coverage:0.4.0")
    testImplementation("org.camunda.bpm.extension:camunda-bpm-assert-scenario:1.0.0")
    testImplementation("org.slf4j:jul-to-slf4j:1.7.30")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
