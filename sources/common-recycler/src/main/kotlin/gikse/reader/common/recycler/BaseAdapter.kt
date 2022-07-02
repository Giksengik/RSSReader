package gikse.reader.common.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * @author e.a.vlasov
 */
abstract class BaseAdapter<T : ListItem>(
    internal val holderFactory: HolderFactory,
) : RecyclerView.Adapter<BaseViewHolder<ListItem>>() {

    abstract val items: List<T>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ListItem> =
        holderFactory(parent, viewType)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: BaseViewHolder<ListItem>, position: Int) =
        holder.bind(items[position])

    override fun onBindViewHolder(
        holder: BaseViewHolder<ListItem>,
        position: Int,
        payloads: MutableList<Any>
    ) = holder.bind(items[position], payloads)

    override fun getItemViewType(position: Int): Int = items[position].viewTyped
}
