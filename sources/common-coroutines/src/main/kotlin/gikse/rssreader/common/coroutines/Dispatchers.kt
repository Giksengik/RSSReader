package gikse.rssreader.common.coroutines

import kotlinx.coroutines.CoroutineDispatcher

/**
 * @author e.a.vlasov
 */
interface Dispatchers {
    fun io(): CoroutineDispatcher
    fun default(): CoroutineDispatcher
    fun unconfined(): CoroutineDispatcher
    fun main(): CoroutineDispatcher
}
