package gikse.rssreader

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import gikse.rssreader.common.ui.view.TintedImageView

/**
 * @author e.a.vlasov
 */
class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_layout)

        findViewById<TintedImageView>(R.id.tintedImage)
    }
}
