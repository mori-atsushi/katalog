package jp.co.cyberagent.katalog.ext

@Deprecated(
    "The package name has changed.",
    ReplaceWith(
        "ExtComponentWrapper",
        "com.moriatsushi.katalog.ext.ExtComponentWrapper"
    )
)
@ExperimentalKatalogExtApi
public typealias ExtComponentWrapper = com.moriatsushi.katalog.ext.ExtComponentWrapper

@Deprecated(
    "The package name has changed.",
    ReplaceWith(
        "ExtRootWrapper",
        "com.moriatsushi.katalog.ext.ExtRootWrapper"
    )
)
@ExperimentalKatalogExtApi
public typealias ExtRootWrapper = com.moriatsushi.katalog.ext.ExtRootWrapper

@Deprecated(
    "The package name has changed.",
    ReplaceWith(
        "ExperimentalKatalogExtApi",
        "com.moriatsushi.katalog.ext.ExperimentalKatalogExtApi"
    )
)
// https://youtrack.jetbrains.com/issue/KT-56715
@Suppress("OPT_IN_MARKER_CAN_ONLY_BE_USED_AS_ANNOTATION_OR_ARGUMENT_IN_OPT_IN")
public typealias ExperimentalKatalogExtApi = com.moriatsushi.katalog.ext.ExperimentalKatalogExtApi
