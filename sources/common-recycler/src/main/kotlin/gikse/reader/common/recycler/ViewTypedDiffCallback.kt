package gikse.reader.common.recycler

import androidx.recyclerview.widget.DiffUtil

/**
 * @author e.a.vlasov
 */
class ViewTypedDiffCallback<T : ListItem>() : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean = oldItem.uid == newItem.uid

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean = oldItem.equals(newItem)
}
