package gikse.rssreader.common.android.resource.di

import android.content.Context
import gikse.rssreader.common.di.LazyComponentHolder
import gikse.rssreader.common.di.DIComponent

/**
 * @author e.a.vlasov
 */
fun interface ContextComponent : DIComponent {

    fun context(): Context
}

object ContextComponentHolder : LazyComponentHolder<ContextComponent>()
