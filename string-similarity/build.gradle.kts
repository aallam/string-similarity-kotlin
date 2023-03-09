import org.jetbrains.kotlin.konan.target.HostManager

plugins {
    kotlin("multiplatform")
    id("com.vanniktech.maven.publish")
    id("binary-compatibility-validator")
    id("com.diffplug.spotless")
    id("org.jetbrains.dokka")
}

kotlin {
    explicitApi()
    jvm()
    js {
        compilations.all {
            kotlinOptions {
                moduleKind = "umd"
                sourceMap = true
                metaInfo = true
                main = "noCall"
                sourceMapEmbedSources = "always"
            }
        }
        nodejs()
        browser()
    }

    // Tier 1
    linuxX64()

    // Tier 2
    linuxArm64()

    // Tier 3
    androidNativeArm32()
    androidNativeArm64()
    androidNativeX86()
    androidNativeX64()
    mingwX64()

    // Apple macOS hosts only
    if (HostManager.hostIsMac) {
        // Tier 1
        macosX64()
        macosArm64()
        iosSimulatorArm64()
        iosX64()

        // Tier 2
        watchosSimulatorArm64()
        watchosX64()
        watchosArm32()
        watchosArm64()
        tvosSimulatorArm64()
        tvosX64()
        tvosArm64()
        iosArm64()

        // Tier 3
        watchosDeviceArm64()
    }

    sourceSets {
        all {
            languageSettings.optIn("kotlin.ExperimentalStdlibApi")
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test.common)
                implementation(libs.kotlin.test.annotations.common)
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(libs.kotlin.test.junit)
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(libs.kotlin.test.js)
            }
        }
    }
}
