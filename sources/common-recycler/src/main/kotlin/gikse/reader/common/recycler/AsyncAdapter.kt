package gikse.reader.common.recycler

import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil

/**
 * @author e.a.vlasov
 */
class AsyncAdapter<T: ListItem>(
    holderFactory: HolderFactory,
    diffItemCallback: DiffUtil.ItemCallback<T>,
) : BaseAdapter<T>(holderFactory) {

    private val asyncListDiffer = AsyncListDiffer(this, diffItemCallback)

    override var items: List<T>
        get() = asyncListDiffer.currentList
        set(newItems) = asyncListDiffer.submitList(newItems)
}
