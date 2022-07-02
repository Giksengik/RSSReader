package gikse.rssreader.feature.main.ui.presentation.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import gikse.rssreader.feature.main.ui.R
import gikse.rssreader.feature.main.ui.databinding.FragmentMainBinding

/**
 * @author e.a.vlasov
 */
class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}
