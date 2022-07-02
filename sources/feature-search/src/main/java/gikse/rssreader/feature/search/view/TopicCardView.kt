package gikse.rssreader.feature.search.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.cardview.widget.CardView
import gikse.rssreader.common.ui.view.TintedImageView
import gikse.rssreader.feature.search.R

/**
 * @author e.a.vlasov
 */
class TopicCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0,
) : CardView(context, attrs, defStyleAttr) {

    var subtitleText: String
        get() = subtitle.text.toString()
        set(value) {
            subtitle.text = value
        }

    var titleText: String
        get() = title.text.toString()
        set(value) {
            title.text = value
        }

    @ColorInt
    var topGradientColor = TintedImageView.UNDEFINED_COLOR
        private set

    @ColorInt
    var bottomGradientColor = TintedImageView.UNDEFINED_COLOR
        private set

    private var title: TextView

    private var subtitle: TextView

    var backgroundImage: TintedImageView

    init {
        val inflater = LayoutInflater.from(context)
        val root = inflater.inflate(R.layout.topic_card_layout, this, true)

        title = root.findViewById(R.id.title)
        subtitle = root.findViewById(R.id.subtitle)
        backgroundImage = root.findViewById(R.id.backgroundImage)

        initializeAttrs(attrs, defStyleAttr, defStyleRes)
    }

    private fun initializeAttrs(attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) {
        if (attrs != null) {

            val typedArray = context.obtainStyledAttributes(
                attrs,
                R.styleable.TopicCardView,
                defStyleAttr,
                defStyleRes,
            )

            subtitleText = typedArray.getString(R.styleable.TopicCardView_subtitleText) ?: ""
            titleText = typedArray.getString(R.styleable.TopicCardView_titleText) ?: ""
            topGradientColor = typedArray.getColor(
                R.styleable.TopicCardView_topGradientColor,
                TintedImageView.UNDEFINED_COLOR
            )
            bottomGradientColor = typedArray.getColor(
                R.styleable.TopicCardView_topGradientColor,
                TintedImageView.UNDEFINED_COLOR
            )

            val backgroundDrawable = typedArray.getDrawable(R.styleable.TopicCardView_backgroundSrc)

            backgroundImage.apply {
                setVerticalGradientTint(
                    topGradientColor,
                    bottomGradientColor
                )
                setBackgroundDrawable(backgroundDrawable)
            }

            typedArray.recycle()
        }
    }
}

