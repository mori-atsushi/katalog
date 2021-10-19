# Katalog - A UI Catalog Library made with [Jetpack Compose](https://developer.android.com/jetpack/compose)

**🚧 This project is in progress 🚧**
```text
I welcome your contributions and feedback.
Katalog may be made breaking changes in the future.
```

## Features
* It is made with  [Jetpack Compose](https://developer.android.com/jetpack/compose) and You can preview Composable.
* You can easily register and group UI components using the `DSL`.
* It supports [Android View](https://developer.android.com/reference/android/view/View), [DataBinding](https://developer.android.com/topic/libraries/data-binding), [ViewBinding](https://developer.android.com/topic/libraries/view-binding) and [Fragment](https://developer.android.com/guide/components/fragments).

# Getting Started
## step1: Add the dependency

Add GitHub Packages repository to your build.gradle file.
Set your `GITHUB_USERNAME` and `GITHUB_TOKEN`.

```kotlin
repositories {
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/cyberagent-zemi/katalog")
        credentials {
            username = `GITHUB_USERNAME`
            password = `GITHUB_TOKEN`
        }
    }
}
```

Add the package dependencies to your build.gradle file.
Please check `LATEST_VERSION` from [here](https://github.com/cyberagent-zemi/katalog/packages/886303).

```kotlin
dependencies {
    implementation("co.jp.cyberagent.katalog:katalog-android:`LATEST_VERSION`")
}
```

## step2: Register the UI component

Just run the `registerKatalog` function in your application.
To register a `Composable`, use the `compose` function.

```kotlin
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        registerKatalog(
            title = "My App Catalog"
        ) {
            compose("UI Component") {
                Text(text = "Hello, World")
            }
        }
    }
}
```

You can use the `group` function to group components.

```kotlin
registerKatalog(
    title = "My App Catalog"
) {
    group("Group 1") {
        compose("UI Component") {
            /* ... */
        }
    }

    group("Group 2") {
        /* ... */
    }
}
```

The `group` can also be assigned to a variable.

```kotlin
val group1 = group("Group 1") {
    /* ... */
}
val group2 = group("Group 2") {
    /* ... */
}
registerKatalog {
    title = "My App Catalog"
    group(group1, group2)
}
```

## step3: Start Catalog Activity

Start `KatalogActivity` from your debug menu.

```kotlin
KatalogActivity.start(activity)
```

## Ideas
* Search function.
* Combine with Screenshot Test.
* Provide some Addons.
* Support [Compose for Desktop](https://www.jetbrains.com/lp/compose/).
* Support [Compose for Web](https://compose-web.ui.pages.jetbrains.team/).
