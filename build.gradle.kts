@file:Suppress("OPT_IN_USAGE")

import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    kotlin("multiplatform") version "2.1.0-RC2"
}

version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}


kotlin {
    wasmJs() {
        binaries.executable()
        browser {
            commonWebpackConfig {
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).copy(
                    static = (devServer?.static ?: mutableListOf()).apply {
                        // Serve sources to debug inside browser
                        add(project.rootDir.path)
                    },
                )
            }

        }
    }
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-test:2.1.0-RC2")
            }
        }
        val wasmJsMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-browser:0.2")
            }
        }
        val wasmJsTest by getting
    }

}

rootProject.the<NodeJsRootExtension>().apply {
    version = "22.9.0"
}
