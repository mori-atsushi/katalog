---
sidebar_position: 2
---
# Register and Start
## Register Katalog
Just run `registerKatalog` function in your application.

```kotlin
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        registerKatalog(
            title = "My App Catalog",
            extensions = emptyList(),
        ) {
            compose(
                name = "UI Component"
            ) {
                Text(text = "Hello, World")
            }
        }
    }
}
```
* `registerKatalog` - Set up Katalog. **Call this function only once in the application.**
  * `title` - Set title of UI Catalog. It is optional.
  * `extensions` - Set the extension. It is optional ([Detail](/docs/main/extensions/compose-theme)).
* `compose` - Register Component of Jetpack Compose.
  * `name` - Set component name.
  * `definition` - Call Compose function.

:::info
When using Katalog in a production application, make sure that the code and the dependencies are not included in production.
Katalog can be used only in debug build by setting as follows:
```kotlin title="build.gradle"
dependencies {
    // Use only in debug build
    debugImplementation("co.jp.cyberagent.katalog:katalog-android:`LATEST_VERSION`")
}
```
```kotlin title="src/debug/DebugApplication.kt"
// Extends the release application class.
class DebugApplication : MyApplication() {
    override fun onCreate() {
        super.onCreate()

        registerKatalog(
            title = "My App Catalog"
        ) {
            /* ... */
        }
    }
}
```
:::

## Grouping
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

## Start Katalog
Start `KatalogActivity` from your debug menu.

```kotlin
KatalogActivity.start(activity)
```

:::tip
You can set `KatalogActivity` as the default Activity.
It will be useful if you are using Katalog as an independent application.

```xml title=AndroidManifest.xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="jp.co.cyberagent.katalog.android_sample">

    <application
        android:icon="@mipmap/ic_launcher"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:name=".SampleApp"
        android:label="Katalog Sample">

        <activity
            android:name="jp.co.cyberagent.katalog.KatalogActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>

    </application>

</manifest>
```
:::
