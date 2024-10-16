plugins {
    id ("java-library")
    id ("io.qameta.allure") version ("2.11.2")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.seleniumhq.selenium:selenium-java:4.24.0")
    testImplementation("io.github.bonigarcia:webdrivermanager:5.9.1")

    testImplementation ("org.aspectj:aspectjweaver:1.9.5")
    testImplementation ("io.qameta.allure:allure-junit5:2.12.1")
    testImplementation ("io.qameta.allure:allure-commandline:2.12.1")
    testImplementation ("io.qameta.allure:allure-assertj:2.12.1")
    testImplementation ("io.qameta.allure:allure-rest-assured:2.12.1")
    testImplementation ("io.qameta.allure:allure-java-commons:2.12.1")
}

tasks.test {
    useJUnitPlatform()
}
