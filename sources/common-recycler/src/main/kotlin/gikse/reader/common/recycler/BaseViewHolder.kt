package gikse.reader.common.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @author e.a.vlasov
 */
open class BaseViewHolder<T : ListItem>(
    containerView: View,
) : RecyclerView.ViewHolder(containerView) {

    open fun bind(item: T) = Unit

    open fun bind(item: T, payload: List<Any>) = Unit
}
