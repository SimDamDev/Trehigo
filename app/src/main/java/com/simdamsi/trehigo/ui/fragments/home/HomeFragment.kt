package com.simdamsi.trehigo.ui.fragments.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.simdamsi.trehigo.R
import com.simdamsi.trehigo.databinding.FragmentHomeBinding
import com.simdamsi.trehigo.interfaces.CommonFunctions
import com.simdamsi.trehigo.interfaces.OnFragmentInteractionListener
import dagger.hilt.android.AndroidEntryPoint
import org.imaginativeworld.oopsnointernet.snackbars.fire.NoInternetSnackbarFire
import timber.log.Timber

@AndroidEntryPoint
class HomeFragment : Fragment(), CommonFunctions {

    private var listener: OnFragmentInteractionListener? = null

    private lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        Timber.d("onCreate")
        super.onCreate(savedInstanceState)

        initObservers()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Timber.d("onCreateView")

        binding = FragmentHomeBinding.inflate(inflater)
        binding.lifecycleOwner = this.viewLifecycleOwner
        binding.viewModel = viewModel

        NoInternetSnackbarFire.Builder(binding.mainContainer, viewLifecycleOwner.lifecycle).build()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Timber.d("onViewCreated")
        super.onViewCreated(view, savedInstanceState)

        listener?.setAppTitle(getString(R.string.app_name))

        listener?.hideLoading()

        initViews()

        initListeners()
    }

    override fun onResume() {
        Timber.d("onResume")
        super.onResume()
    }
    override fun initListeners() {

        binding.btn1.setOnClickListener {

            listener?.gotoFragment(R.id.homeFragment)
        }
/*
        binding.btnPost.setOnClickListener {

            listener?.gotoFragment(R.id.postFragment)
        }

        binding.btnPostPaged.setOnClickListener {

            listener?.gotoFragment(R.id.postPagedFragment)
        }

        binding.btnCustomSnackbar.setOnClickListener {

            CustomSnackbar.make(
                binding.root,
                "Hi! I am a custom Snackbar!",
                Snackbar.LENGTH_INDEFINITE
            )
                .setAction("Ok", View.OnClickListener {})
                .show()
        }

        binding.btnCarousel.setOnClickListener {

            listener?.gotoFragment(R.id.demoCarouselFragment)
        }
*/
        /*binding.btnDarkMode.setOnClickListener {

            val isNightTheme = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK

            when (isNightTheme) {
                Configuration.UI_MODE_NIGHT_YES ->
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                Configuration.UI_MODE_NIGHT_NO ->
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }*/
    }

    override fun onAttach(context: Context) {
        Timber.d("onAttach")
        super.onAttach(context)

        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        Timber.d("onDetach")
        super.onDetach()
        listener = null
    }
}
