plugins {
    java
    antlr
    application
    id("com.github.ben-manes.versions") version "0.38.0"
}

group = "de.ktskoeln.inf"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    antlr("org.antlr:antlr4:4.9.2")
}

application {
    mainClass.set("${project.group}.${project.name}.MainProgram")
}

tasks.getByName<JavaExec>("run") {
    standardInput = System.`in`
}

tasks.generateGrammarSource {
    arguments = arguments + listOf("-no-listener", "-visitor", "-long-messages", "-package", "${project.group}.${project.name}")
}