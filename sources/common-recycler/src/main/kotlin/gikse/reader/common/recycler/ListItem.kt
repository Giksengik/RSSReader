package gikse.reader.common.recycler

/**
 * @author e.a.vlasov
 */
interface ListItem {

    val viewTyped: Int

    val uid: String
        get() = error("uid for this list item not specified")
}
