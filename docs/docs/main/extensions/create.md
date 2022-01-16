---
sidebar_position: 1000
---
# Create a Extension

:::caution
The creation of extensions is **experimental**.
The APIs can change in the future or may be removed entirely.
:::

## Basic

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

```kotlin {4}
registerKatalog(
    title = "Android Sample",
    extensions = listOf(
        createSampleExt() // append this line
    )
) {
    /* ... */
}
```

## NavState
You can open a specific page from the extension.
You can also observe the current page transitions.

### Screen transition
You can access `NavState` within `setRootWrapper` or `setComponentWrapper`.
Use a `navigateTo` method to move to a specific [page ID](#page-id).

```kotlin {4}
val ext = KatalogExt.Builder("Screen transition")
    .setRootWrapper { content ->
        LaunchedEffect(Unit) {
            navState.navigateTo("/Group/Item") // specify a page to transition
        }
        content()
    }
    .build()
```

### Restore screen back stack
You can overwrite the entire back stack by using the `restore` method.

```kotlin {4}
val ext = KatalogExt.Builder("Restore screen back stack")
    .setRootWrapper { content ->
        LaunchedEffect(Unit) {
            navState.restore(listOf("/", "/Group", "/Group/Item"))
        }
        content()
    }
    .build()
```

### Observe screen transitions
The `current` variable represents the current page and the `backStack` variable represents the current page and the pages behind it.

It is also possible to convert to Flow and observe them by using `snaphostFlow` method.

```kotlin {4,8}
val ext = KatalogExt.Builder("Observe screen transitions")
    .setRootWrapper { content ->
        LaunchedEffect(Unit) {
            snaphostFlow { navState.current }
                .onEach { Log.d("current", it) }
                .launchIn(this)

            snaphostFlow { navState.backStack }
                .onEach { Log.d("back stack", it.toString) }
                .launchIn(this)
        }
        content()
    }
    .build()
```

### Page ID {#page-id}

The page ID is a concatenation of the names of groups and components.
The root page ID is `/`.

```kotlin
registerKatalog(
    title = "My App Catalog"
) {
    // root page: /
    group("Group") { // group page: /Group
        compose("Item") { // component page: /Group/Item
            /* ... */
        }
    }
}
```

If they have the same name, they will be numbered.

```kotlin
registerKatalog(
    title = "My App Catalog"
) {
    group("Group") { // group page: /Group
        compose("Item") { // component page: /Group/Item
            /* ... */
        }
        compose("Item") { // component page: /Group/Item(2)
            /* ... */
        }
    }
    group("Group") { // group page: /Group(2)
        compose("Item") { // component page: /Group(2)/Item
            /* ... */
        }
    }
}
```

If you use the following symbols in the name, they will be replaced according to the table.

name|id
:--|:--
%|%25
(|%28
)|%29
/|%2F

```kotlin
registerKatalog(
    title = "My App Catalog"
) {
    group("Group/Item") { // group page: /Group%2FItem
        compose("Item") { // component page: /Group%2FItem/Item
            /* ... */
        }
    }
    group("Group(2)") { // group page: /Group%282%2F
        /* ... */
    }
    group("/Group%282%2F") { // group page: /Group%25282%252F
        /* ... */
    }
}
