plugins {
    java
    id("com.gradleup.shadow") version "8.3.2"
}

repositories {
    mavenLocal()
    maven("https://jitpack.io/")
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://repo.maven.apache.org/maven2/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.1-R0.1-SNAPSHOT")
    compileOnly("com.github.SlimeFun-Lab:Slimefun4:3ea21da")

    implementation("org.bstats:bstats-bukkit:3.0.2")
    implementation("com.github.seggan:ErrorReporter-Java:1.1.0")
    implementation("commons-lang:commons-lang:2.6")

    compileOnly("com.google.code.findbugs:jsr305:3.0.2")
    compileOnly("org.projectlombok:lombok:1.18.38")
    annotationProcessor("org.projectlombok:lombok:1.18.38")
}

group = "io.github.seggan.sfcalc"
version = "UNOFFICIAL"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

tasks.processResources {
    filesMatching("plugin.yml") {
        expand("version" to project.version)
    }
}

tasks.shadowJar {
    archiveClassifier.set("")

    relocate("io.github.seggan.errorreporter", "io.github.seggan.sfcalc.errorreporter")
    relocate("org.bstats", "io.github.seggan.sfcalc.bstats")
}
