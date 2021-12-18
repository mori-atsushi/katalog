package jp.co.cyberagent.katalog.ext

@ExperimentalKatalogExtApi
public interface ExtNavState {
    public val current: String
    public val backStack: List<String>

    public suspend fun navigateTo(destination: String): Boolean
    public suspend fun restore(backStack: List<String>): Boolean
}
