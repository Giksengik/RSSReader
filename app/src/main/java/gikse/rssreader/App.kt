package gikse.rssreader

import android.app.Application
import android.content.Context
import gikse.rssreader.common.android.resource.di.ContextComponent
import gikse.rssreader.common.android.resource.di.ContextComponentHolder

/**
 * @author e.a.vlasov
 */
class App : Application() {

    lateinit var context: Context

    override fun onCreate() {
        super.onCreate()
        context = this

        initializeLazyComponents()
    }

    private fun initializeLazyComponents() {
        ContextComponentHolder.set { ContextComponent { context } }
    }

}
