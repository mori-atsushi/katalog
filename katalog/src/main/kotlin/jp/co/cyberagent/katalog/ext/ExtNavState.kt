package jp.co.cyberagent.katalog.ext

@ExperimentalKatalogExtApi
public interface ExtNavState {
    public val current: String
    public val backStack: List<String>

    public fun navigateTo(destination: String): Boolean
    public fun restore(backStack: List<String>): Boolean
}
