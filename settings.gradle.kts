pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_PROJECT)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "FilimoChallenge"
include(":app",
    ":domain", ":data")
includeBuild("DependenciesPlugin")
includeBuild("BuildConfigPlugin")

