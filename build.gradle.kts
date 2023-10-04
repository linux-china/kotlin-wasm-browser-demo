@file:Suppress("OPT_IN_USAGE")

import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    kotlin("multiplatform") version "1.9.20-Beta2"
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
                implementation(kotlin("test"))
            }
        }
        val wasmJsMain by getting
        val wasmJsTest by getting
    }
}

rootProject.the<NodeJsRootExtension>().apply {
    nodeVersion = "20.8.0"
}
