
plugins {

    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("myBuildConfig")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("myDependencies")


}

android {
    compileSdk = Android.COMPILE_SDK_VERSION

    defaultConfig {
        applicationId = Android.APPLICATION_ID
        minSdk = Android.MIN_SDK_VERSION
        targetSdk = Android.TARGET_SDK_VERSION
        versionCode = Android.VERSION_CODE
        versionName = Android.VERSION_NAME

        testInstrumentationRunner =  "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles( getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        compose = true
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0-beta02"
    }
}

dependencies {

    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    api(LibDependency.COROUTINES_ANDROID)
    api(LibDependency.COROUTINES)
    api (LibDependency.CORE_KTX)

    api (LibDependency.KOTLIN)
    api (LibDependency.KOTLIN_RUNTIME)


    api(LibDependency.LIFECYCLE_EXTENSIONS)
    api(LibDependency.LIFECYCLE_PROCESS)
    api(LibDependency.LIFE_CYCLES_RUN_TIME)

    api (LibDependency.APP_COMPAT)

    api(LibDependency.COMPOSE_ACTIVITY)
    api(LibDependency.COMPOSE_MATERIAL)
    api(LibDependency.COMPOSE_UI_TOOLING)
    api(LibDependency.COMPOSE_VIEW_MODEL_LIFE_CYCLE)
    api(LibDependency.COMPOSE_NAVIGATION)
    api(LibDependency.COMPOSE_KOIN)
    api(LibDependency.COMPOSE_GLIDE)
    api(LibDependency.COMPOSE_RUNTIME_LIVE_DATA)
    api(LibDependency.COMPOSE_COIL)

}