---
sidebar_position: 1
---
# What is Katalog?
Katalog is a UI Catalog Library made with Jetpack Compose.

## Why using the UI Catalog?
When implementing complex UIs, you need to be aware of various things such as omissions and degradation.

The UI Catalog can be build UIs separately from the logic, so it is easy to reproduce hard-to-reach states and edge cases.
It will be useful for reuse UIs by organizing and managing UI components.

The UI Catalog will powerfully help for your development.

## Features of Katalog

It is made with `Jetpack Compose` and you can preview `Composable`.
You can easily register and group UI components using the `DSL` , as shown below.

```kotlin
registerKatalog(
    title = "My App Catalog"
) {
    compose("UI Component") {
        Text(text = "Hello, World")
    }

    group("Group 1") {
        compose("UI Component 1") {
            /* ... */
        }

        compose("UI Component 2") {
            /* ... */
        }
    }
}
```
In addition to [Composable](/docs/main/jetpack-compose), the following UI components are supported
* [Android View](/docs/main/android-view)
* [DataBinding / ViewBinding](/docs/main/binding)
* [Fragment](/docs/main/fragment)

### Extensions
Katalog provides additional features as Extensions.
Currently, the following extensions are available.
* [Compose Theme](/docs/main/extensions/compose-theme)
* [Android Theme](/docs/main/extensions/android-theme)

You can create an Extension.
Please refer to [this document](/docs/main/extensions/create) for more information.

## Sample App
Check out the sample app [here](https://github.com/cyberagent-zemi/katalog/tree/main/samples/android-sample).

## Ideas
We consider adding the following features:
* Search function.
* Combine with Screenshot Test.
* Provide some Addons.
* Support [Compose for Desktop](https://www.jetbrains.com/lp/compose/).
* Support [Compose for Web](https://compose-web.ui.pages.jetbrains.team/).

If you have any other ideas or problems, please let us know in [Issue](https://github.com/cyberagent-zemi/katalog/issues).

## References
This library is inspired by the following libraries:
* [Storybook](https://storybook.js.org/) - for web-frontend
* [Playbook](https://github.com/playbook-ui/playbook-ios) - for iOS
* [Showkase](https://github.com/airbnb/Showkase) - for Jetpack Compose (Android)
