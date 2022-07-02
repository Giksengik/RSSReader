package gikse.rssreader.common.di

import java.lang.ref.WeakReference

/**
 * @author e.a.vlasov
 */
// Сеттится через build и чиститься, когда не используется
abstract class FeatureComponentHolder<Component : DIComponent> : BaseComponentHolder<Component>,
    ImmediateComponentInitializer<Component> {

    @Volatile
    private var component: WeakReference<Component>? = null

    override fun get(): Component {
        return component?.get() ?: synchronized(this) {
            component?.get() ?: build().also(::set)
        }
    }

    override fun set(component: Component) {
        this.component = WeakReference(component)
    }

    protected abstract fun build(): Component

    override fun clear() {
        component = null
    }
}
