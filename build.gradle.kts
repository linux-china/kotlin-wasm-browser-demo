@file:Suppress("OPT_IN_USAGE")

plugins {
    kotlin("multiplatform") version "1.8.20"
}

version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}


kotlin {
    wasm {
        binaries.executable()
        browser()
    }
}
