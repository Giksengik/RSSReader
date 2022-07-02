package gikse.rssreader.common.di

/**
 * @author e.a.vlasov
 */
// Сетится вручную(set) и живет пока живо приложение, инициализируется лениво
open class LazyComponentHolder<Component : DIComponent> : BaseComponentHolder<Component>,
    LazyComponentInitializer<Component> {

    @Volatile
    private var component: Component? = null
    private var componentProvider: () -> Component =
        { error("${javaClass.simpleName} — component provider not found") }

    override fun get(): Component {
        return component ?: synchronized(this) {
            component ?: componentProvider().also(::set)
        }
    }

    private fun set(component: Component) {
        this.component = component
    }

    override fun set(componentProvider: () -> Component) {
        this.componentProvider = componentProvider
    }

    override fun clear() {
        component = null
    }
}
