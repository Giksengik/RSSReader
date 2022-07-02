package gikse.rssreader.common.di

/**
 * @author e.a.vlasov
 */
// Сетится в build и живет пока живо приложение, инициализируется лениво
abstract class ComponentHolder<Component : DIComponent> : BaseComponentHolder<Component>,
    ImmediateComponentInitializer<Component> {

    @Volatile
    private var component: Component? = null

    override fun get(): Component {
        return component ?: synchronized(this) {
            component ?: build().also(::set)
        }
    }

    override fun set(component: Component) {
        this.component = component
    }

    protected abstract fun build(): Component

    override fun clear() {
        component = null
    }
}
