package gikse.rssreader.common.ui.view

import android.content.Context
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.util.AttributeSet
import androidx.annotation.ColorInt
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatImageView
import gikse.rssreader.common.ui.R
import java.lang.IllegalStateException
import android.graphics.PorterDuffXfermode

import android.graphics.Shader

import android.graphics.LinearGradient

import android.graphics.Paint

import android.graphics.Canvas

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import gikse.rssreader.common.ui.util.addTransparencyToColor
import java.lang.IllegalArgumentException


/**
 * @author e.a.vlasov
 */
class TintedImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : AppCompatImageView(context, attrs, defStyleAttr) {

    init {
        initializeAttributes(attrs, defStyleAttr)
        adjustViewBounds = true
        scaleType = ScaleType.CENTER_CROP
    }

    var typeOfTint: TypeOfTint = TypeOfTint.SOLID
        private set

    @ColorInt
    var tintColor: Int = UNDEFINED_COLOR
        private set

    @ColorInt
    var gradientStartTintColor: Int = UNDEFINED_COLOR
        private set

    @ColorInt
    var gradientEndTintColor: Int = UNDEFINED_COLOR
        private set

    var transparency: Float = DEFAULT_TRANSPARENCY
        private set

    private fun initializeAttributes(attrs: AttributeSet?, defStyleAttr: Int) {
        if (attrs == null) return

        val typedArray =
            context.obtainStyledAttributes(attrs, R.styleable.TintedImageView, defStyleAttr, 0)
        typeOfTint =
            TypeOfTint.values()[typedArray.getInt(R.styleable.TintedImageView_typeOfTint, 0)]

        tintColor = typedArray.getColor(R.styleable.TintedImageView_tintColor, UNDEFINED_COLOR)

        gradientEndTintColor = typedArray.getColor(
            R.styleable.TintedImageView_gradientEndTintColor,
            UNDEFINED_COLOR
        )

        gradientStartTintColor = typedArray.getColor(
            R.styleable.TintedImageView_gradientStartTintColor,
            UNDEFINED_COLOR
        )

        transparency =
            typedArray.getFloat(R.styleable.TintedImageView_tintTransparency, DEFAULT_TRANSPARENCY)

        typedArray.recycle()
        setTint()
    }

    private fun setTint() {
        if (typeOfTint == TypeOfTint.SOLID)
            setSolidTint()
        else setGradientTint()
    }

    private fun setSolidTint() {
        if (tintColor == UNDEFINED_COLOR) return

        colorFilter = PorterDuffColorFilter(
            addTransparencyToColor(tintColor, transparency),
            PorterDuff.Mode.SRC_ATOP,
        )
    }

    private fun setGradientTint() {
        if (gradientEndTintColor == UNDEFINED_COLOR || gradientStartTintColor == UNDEFINED_COLOR) return

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
            setupGradientWithForeground()
        } else {
            setupGradientWithBitmap()
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun setupGradientWithForeground() {
        val orientation = when (typeOfTint) {
            TypeOfTint.GRADIENT_VERTICAL -> GradientDrawable.Orientation.TOP_BOTTOM
            TypeOfTint.GRADIENT_HORIZONTAL -> GradientDrawable.Orientation.LEFT_RIGHT
            TypeOfTint.GRADIENT_DIAGONAL_L -> GradientDrawable.Orientation.TL_BR
            TypeOfTint.GRADIENT_DIAGONAL_R -> GradientDrawable.Orientation.TR_BL
            else -> throw IllegalStateException("Wrong orientation")
        }
        val gradient = GradientDrawable(
            orientation,
            intArrayOf(
                addTransparencyToColor(gradientStartTintColor, transparency),
                addTransparencyToColor(gradientEndTintColor, transparency),
            )
        )
        gradient.setSize(width, height)
        foreground = gradient
    }

    private fun setupGradientWithBitmap() {
        val originalBitmap = (drawable as BitmapDrawable).bitmap
        val width: Int = originalBitmap.width
        val height: Int = originalBitmap.height
        val updatedBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(updatedBitmap)
        canvas.drawBitmap(originalBitmap, 0f, 0f, null)
        val paint = Paint()
        paint.shader = getShader(width, height)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP)
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paint)
        setImageDrawable(BitmapDrawable(resources, updatedBitmap))
    }

    private fun getShader(width: Int, height: Int): LinearGradient {
        val startX: Float
        val startY: Float
        val endX: Float
        val endY: Float

        when (typeOfTint) {
            TypeOfTint.GRADIENT_VERTICAL -> {
                startX = 0f
                startY = 0f
                endX = 0f
                endY = height.toFloat()
            }
            TypeOfTint.GRADIENT_HORIZONTAL -> {
                startX = 0f
                startY = 0f
                endX = width.toFloat()
                endY = 0f
            }
            TypeOfTint.GRADIENT_DIAGONAL_R -> {
                startX = width.toFloat()
                startY = 0f
                endX = 0F
                endY = height.toFloat()
            }
            TypeOfTint.GRADIENT_DIAGONAL_L -> {
                startX = 0f
                startY = 0f
                endX = width.toFloat()
                endY = height.toFloat()
            }
            else -> throw IllegalStateException("wrong type of tint expected gradient and got $typeOfTint")
        }

        return LinearGradient(
            startX,
            startY,
            endX,
            endY,
            addTransparencyToColor(gradientStartTintColor, transparency),
            addTransparencyToColor(gradientEndTintColor, transparency),
            Shader.TileMode.CLAMP
        )
    }

    fun setSolidTint(@ColorInt tintColorInt: Int) {
        tintColor = tintColorInt
        typeOfTint = TypeOfTint.SOLID
        setTint()
    }

    fun setGradientTint(
        typeOfTint: TypeOfTint,
        @ColorInt startGradientColor: Int,
        @ColorInt endGradientColor: Int,
    ) {
        if (!typeOfTint.isGradient)
            throw IllegalArgumentException("type of ting must be gradient")

        this.gradientStartTintColor = startGradientColor
        this.gradientEndTintColor = endGradientColor
        this.typeOfTint = typeOfTint

        setTint()
    }

    fun setVerticalGradientTint(
        @ColorInt startGradientColor: Int,
        @ColorInt endGradientColor: Int,
    ) = setGradientTint(TypeOfTint.GRADIENT_VERTICAL, startGradientColor, endGradientColor)

    fun setTintTransparency(transparency: Float) {
        this.transparency = transparency
        setTint()
    }

    enum class TypeOfTint(val isGradient: Boolean) {
        SOLID(false),
        GRADIENT_VERTICAL(true),
        GRADIENT_HORIZONTAL(true),
        GRADIENT_DIAGONAL_R(true),
        GRADIENT_DIAGONAL_L(true),
    }

    companion object {
        const val UNDEFINED_COLOR = -1
        const val DEFAULT_TRANSPARENCY = 0.9f
    }
}
