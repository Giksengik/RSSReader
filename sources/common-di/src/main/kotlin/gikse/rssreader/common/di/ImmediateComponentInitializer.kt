package gikse.rssreader.common.di

/**
 * @author e.a.vlasov
 */
interface ImmediateComponentInitializer<Component : DIComponent> {

    fun set(component: Component)
}
