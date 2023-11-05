@file:Suppress("OPT_IN_USAGE")

import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    kotlin("multiplatform") version "1.9.20"
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
    
}

rootProject.the<NodeJsRootExtension>().apply {
    nodeVersion = "21.1.0"
}
