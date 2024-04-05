// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    id("com.google.gms.google-services") version "4.4.1" apply false
    id("org.jetbrains.kotlin.jvm") version "1.8.10" apply false
    id("dev.shreyaspatil.compose-compiler-report-generator") version "1.1.0" apply false
    alias(libs.plugins.androidLibrary) apply false
}
