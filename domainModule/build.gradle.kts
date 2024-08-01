plugins {
    id("java-library")
    // alias(libs.plugins.jetbrains.kotlin.jvm)
    kotlin("jvm")
}

java {
}

dependencies {
    implementation(project(":coreModule"))
    testImplementation(libs.mockito.core)
    testImplementation(libs.junit)
    // Koin
    implementation("io.insert-koin:koin-core:3.5.0")
    implementation(libs.kotlinx.collections.immutable)
    implementation(libs.kotlinx.coroutines.android)
    testImplementation(libs.kotlinx.coroutines.test)
}