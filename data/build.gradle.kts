
plugins {
    id("kotlin")
    id("java-library")
    id("kotlin-android-extensions")
    id("myDependencies")
    id("myBuildConfig")

}


dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":domain"))
    api (LibDependency.GSON)
    api (LibDependency.RETROFIT_CONVERTER)
    api (LibDependency.OKHTTP)
    api (LibDependency.LOGGING)
    api (LibDependency.RETROFIT)
    api (LibDependency.RETROFIT_RX_CONVERTER)
    testImplementation ("junit:junit:4.13.2")
    testImplementation ( "org.mockito:mockito-core:4.6.0")
    testImplementation ( "org.mockito.kotlin:mockito-kotlin:4.0.0")
    testImplementation ( "io.mockk:mockk:1.12.4")

}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}