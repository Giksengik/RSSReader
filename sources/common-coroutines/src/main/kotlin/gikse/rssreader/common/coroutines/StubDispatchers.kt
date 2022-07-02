package gikse.rssreader.common.coroutines

import kotlinx.coroutines.CoroutineDispatcher

/**
 * @author e.a.vlasov
 */
class StubDispatchers(
    private val stubDispatcher: CoroutineDispatcher = kotlinx.coroutines.Dispatchers.Unconfined,
) : Dispatchers {

    override fun io(): CoroutineDispatcher = stubDispatcher
    override fun default(): CoroutineDispatcher = stubDispatcher
    override fun unconfined(): CoroutineDispatcher = stubDispatcher
    override fun main(): CoroutineDispatcher = stubDispatcher
}
