package gikse.rssreader.common.ui.util

import android.graphics.Color
import java.util.*
import kotlin.math.roundToInt

/**
 * @author e.a.vlasov
 */
fun addTransparencyToColor(colorCode: Int, opacity: Float): Int {
    return if (opacity < 1)
        addTransparencyToColor(colorCode, (opacity * 100).roundToInt())
    else
        addTransparencyToColor(colorCode, opacity.roundToInt())
}

fun addTransparencyToColor(colorCode: Int, opacity: Double): Int {
    return if (opacity < 1)
        addTransparencyToColor(colorCode, (opacity * 100).roundToInt())
    else
        addTransparencyToColor(colorCode, opacity.roundToInt())
}

fun addTransparencyToColor(colorCode: Int, opacity: Int): Int {
    var color = "ffffff"
    try {
        color = Integer.toHexString(colorCode).uppercase(Locale.getDefault()).substring(2)
    } catch (ignored: Exception) {
    }
    return Color.parseColor(
        if (!color.isEmpty() && opacity < 100) {
            if (color.trim { it <= ' ' }.length == 6) {
                "#" + convert(opacity) + color
            } else {
                convert(opacity) + color
            }
        } else "#" + Integer.toHexString(Color.BLACK).uppercase(Locale.getDefault()).substring(2)
    )

}

fun convert(trans: Int): String {
    val hexString = Integer.toHexString((255 * trans / 100).toFloat().roundToInt())
    return (if (hexString.length < 2) "0" else "") + hexString
}
