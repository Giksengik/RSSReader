package gikse.rssreader.common.di

/**
 * @author e.a.vlasov
 */
interface BaseComponentHolder<Component : DIComponent> {

    fun get(): Component

    fun clear()
}
