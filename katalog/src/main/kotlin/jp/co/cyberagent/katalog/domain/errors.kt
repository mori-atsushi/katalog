package jp.co.cyberagent.katalog.domain

internal class NotRegisteredException :
    IllegalStateException("require call registerKatalog")

internal class AlreadyRegisteredException :
    IllegalStateException("Cannot call registerKatalog more than once.")
