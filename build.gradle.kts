import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    kotlin("multiplatform") version "1.8.0"
}

version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
}


kotlin {
    wasm {
        binaries.executable()
        browser {
            commonWebpackConfig {
                devServer = KotlinWebpackConfig.DevServer(
                    open = mapOf(
                        "app" to mapOf(
                            "name" to "google chrome",
                            "arguments" to listOf("--js-flags=--experimental-wasm-gc")
                        )
                    ),
                    static = devServer?.static,
                    port = 8000
                )
            }
        }
    }
}
