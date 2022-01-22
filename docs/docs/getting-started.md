---
sidebar_position: 1
---

import { Preview } from '/src/widgets/Preview';
import useBaseUrl from '@docusaurus/useBaseUrl';

# Getting Started
## step1: Add the dependency

Add Maven Central repository to your `build.gradle`.

```kotlin
repositories {
    mavenCentral()
}
```

Add the package dependencies to your `build.gradle`.

```kotlin
dependencies {
    implementation("jp.co.cyberagent.katalog:katalog:1.0.2")
    // If you are using compose 1.1.0-rc01
    // implementation("jp.co.cyberagent.katalog:katalog:1.1.0-beta05")
}
```

## step2: Register the UI component

<Preview
    imageUrl={useBaseUrl('/img/docs/start.png')}
    width={1080}
    height={2280} >

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

</Preview>

<Preview
    imageUrl={useBaseUrl('/img/docs/group.png')}
    width={1080}
    height={2280} >

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

</Preview>

## step3: Start Catalog Activity

Start `KatalogActivity` from your debug menu.

```kotlin
KatalogActivity.start(activity)
```
