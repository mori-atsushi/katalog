---
sidebar_position: 1
---
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
