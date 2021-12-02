<img src="./docs/static/img/logo-clip.svg" width="84px"/>

# Katalog

A UI Catalog Library made with Jetpack Compose

<br />

<img src="./docs/static/img/header-img.png" width="320px" align="right" />

## Features

* It is made with  [Jetpack Compose](https://developer.android.com/jetpack/compose) and you can preview Composable.
* You can easily register and group UI components using the `DSL`.
* It supports [Android View](https://developer.android.com/reference/android/view/View), [DataBinding](https://developer.android.com/topic/libraries/data-binding), [ViewBinding](https://developer.android.com/topic/libraries/view-binding) and [Fragment](https://developer.android.com/guide/components/fragments).

<br clear="all" />

## Getting Started
### step1: Add the dependency

Add Maven Central repository to your `build.gradle`.

```kotlin
repositories {
    mavenCentral()
}
```

Add the package dependencies to your `build.gradle`.

```kotlin
dependencies {
    implementation("jp.co.cyberagent.katalog:katalog:1.0.0")
    // If you are using compose 1.1.0-beta04
    // implementation("jp.co.cyberagent.katalog:katalog:1.1.0-beta01")
}
```

### step2: Register the UI component

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

### step3: Start Catalog Activity

Start `KatalogActivity` from your debug menu.

```kotlin
KatalogActivity.start(activity)
```

### You want to know more?
Please check the [Full Documents](https://cyberagent-zemi.github.io/katalog).

## Ideas
* Search function.
* Combine with Screenshot Test.
* Provide some Addons.
* Support [Compose Multiplatform](https://www.jetbrains.com/lp/compose-mpp).

## License
```
Copyright 2021 CybeAgent, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
