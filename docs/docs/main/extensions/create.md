---
sidebar_position: 3
---
# Create a Extension

:::caution
The creation of extensions is **experimental**.
The APIs can change in the future or may be removed entirely.
:::

You can create an extension by creating `KatalogExt`.
Using the `KatalogExt.Builder` makes it easier.

You can insert the `Composable` for the root and each components.

```kotlin
@OptIn(ExperimentalKatalogExtApi::class)
fun createSampleExt(): KatalogExt {
    // Set the extension name
    val builder = KatalogExt.Builder("Sample Extension")
    // Insert `Composable` for the root.
    builder.setRootWrapper { content ->
        /* ... */
        content()
        /* ... */
    }
    // Insert `Composable` for each components.
    builder.setComponentWrapper { content ->
        /* ... */
        content()
        /* ... */
    }
    return builder.build()
}
```

:::tip
To create an extension, you need to opt-in to `ExperimentalKatalogExtApi`.
:::


To use the extension, specify it when you call the `registerKatalog` method.

```kotlin
registerKatalog(
    title = "Android Sample",
    extensions = listOf(
        createSampleExt()
    )
) {
    /* ... */
}
```
