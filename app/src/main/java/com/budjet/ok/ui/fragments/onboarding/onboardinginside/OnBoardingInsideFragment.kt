package com.budjet.ok.ui.fragments.onboarding.onboardinginside
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.budjet.ok.databinding.OnBoardingInsideFragmentBinding

class OnBoardingInsideFragment : Fragment() {
    private var _binding: OnBoardingInsideFragmentBinding? = null
    private val binding get() = _binding!!
    private  var imageResource:Int = 0
    private lateinit var description: String
    companion object {
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        fun newInstance(description: String?,
                        imageResource: Int) : OnBoardingInsideFragment{
            val fragment = OnBoardingInsideFragment()
            val args = Bundle()
            args.putString(ARG_PARAM2, description)
            args.putInt(ARG_PARAM1, imageResource)
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var viewModel: OnBoardingInsideViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = OnBoardingInsideFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[OnBoardingInsideViewModel::class.java]
        if (arguments != null) {
            description = requireArguments().getString(ARG_PARAM2)!!
            imageResource = requireArguments().getInt(ARG_PARAM1)
        }
        binding.tvDescription.text = description
        binding.ivImage.setImageResource(imageResource)
    }
}