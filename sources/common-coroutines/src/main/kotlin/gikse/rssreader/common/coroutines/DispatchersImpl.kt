package gikse.rssreader.common.coroutines

import kotlinx.coroutines.CoroutineDispatcher

/**
 * @author e.a.vlasov
 */
internal class DispatchersImpl constructor() : Dispatchers {

    override fun io(): CoroutineDispatcher = kotlinx.coroutines.Dispatchers.IO

    override fun default(): CoroutineDispatcher = kotlinx.coroutines.Dispatchers.Default

    override fun unconfined(): CoroutineDispatcher = kotlinx.coroutines.Dispatchers.Unconfined

    override fun main(): CoroutineDispatcher = kotlinx.coroutines.Dispatchers.Main
}
