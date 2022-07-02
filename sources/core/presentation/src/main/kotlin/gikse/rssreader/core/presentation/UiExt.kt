package gikse.rssreader.core.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * @author e.a.vlasov
 */
fun ViewGroup.inflate(resource: Int, attachToRoot: Boolean = false): View =
    LayoutInflater.from(this.context).inflate(resource, this, attachToRoot)
