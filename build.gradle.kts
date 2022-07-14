plugins {
    kotlin("jvm") version "1.7.0"
}

group = "io.github.kookybot"
version = "1.0-SNAPSHOT"

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "17"
        }
    }
}

repositories {
    mavenCentral()
    maven { url = uri("https://libraries.minecraft.net") }
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    // LOG
    implementation("org.slf4j:slf4j-simple:1.7.11")
    // KOOK SDK
    implementation("com.github.KookyBot:KookyBot:0.1.3-SNAPSHOT")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
