package jp.co.cyberagent.katalog.domain

internal class ParamsFactoryImpl : ParamsFactory {
    private var params: Params? = null

    override fun getCatalogParams(): Params {
        return params ?: error("Params is not set yet.")
    }

    fun setCatalogParams(params: Params) {
        this.params = params
    }
}
