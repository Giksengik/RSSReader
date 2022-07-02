package gikse.reader.common.recycler

import android.view.View
import android.view.ViewGroup
import gikse.rssreader.core.presentation.inflate

/**
 * @author e.a.vlasov
 */
abstract class HolderFactory : (ViewGroup, Int) -> BaseViewHolder<ListItem> {

    abstract fun createViewHolder(view: View, viewType: Int): BaseViewHolder<*>?

    override fun invoke(viewGroup: ViewGroup, viewType: Int): BaseViewHolder<ListItem> {
        val view = viewGroup.inflate(viewType)
        return checkNotNull(createViewHolder(view, viewType)) {
            "unknown viewType=" + viewGroup.resources.getResourceName(viewType)
        } as BaseViewHolder<ListItem>
    }
}
