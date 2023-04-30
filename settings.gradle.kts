pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_PROJECT)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Katalog"
include(":katalog")
include(":katalog-androidview")
include(":extensions:theme")
include(":extensions:androidtheme")
include(":extensions:pagesaver")
include(":samples:androidapp")
