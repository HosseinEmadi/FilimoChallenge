
plugins {
    id("kotlin")
    id("java-library")
    id("kotlin-android-extensions")
    id("myDependencies")
    id("myBuildConfig")

}


dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    api(LibDependency.COROUTINES_ANDROID)
    api(LibDependency.COROUTINES)

    api (LibDependency.KOTLIN)
    api (LibDependency.KOTLIN_RUNTIME)
    testImplementation("junit:junit:4.13.2")
    testImplementation ( "org.mockito:mockito-core:4.6.0")
    testImplementation ( "org.mockito.kotlin:mockito-kotlin:4.0.0")
    testImplementation ( "io.mockk:mockk:1.12.4")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}