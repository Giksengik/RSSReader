package gikse.rssreader.common.di

/**
 * @author e.a.vlasov
 */
interface LazyComponentInitializer<Component : DIComponent> {

    fun set(componentProvider: () -> Component)
}
