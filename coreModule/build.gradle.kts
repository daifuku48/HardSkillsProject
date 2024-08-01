plugins {
    id("java-library")
   // alias(libs.plugins.jetbrainsKotlinJvm)
    kotlin("jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}