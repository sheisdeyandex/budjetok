package com.budjet.ok.ui.fragments.onboarding

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.budjet.ok.R
import com.budjet.ok.databinding.OnBoardingFragmentBinding
import com.budjet.ok.ui.adapters.OnBoardingAdapter
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator

class OnBoardingFragment : Fragment() {
    private var _binding: OnBoardingFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var onBoardingAdapter: OnBoardingAdapter
    companion object {
        fun newInstance() = OnBoardingFragment()
    }

    private lateinit var viewModel: OnBoardingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = OnBoardingFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[OnBoardingViewModel::class.java]
        initViewPager()
        binding.btnNext.setOnClickListener {
            initPageChange(view)
        }

    }
    private fun initPageChange(view: View){
        if (getItem() > binding.viewPager.childCount+1) {
            view.findNavController().navigate(R.id.action_OnBoardingFragment_to_chooseFragment)
        } else {
            binding.viewPager.setCurrentItem(getItem() + 1, true)
        }
    }
    private fun initViewPager(){
        binding.viewPager.adapter = OnBoardingAdapter(requireActivity(), requireContext())
        binding.viewPager.offscreenPageLimit = 1
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {

            }

            override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {}
            override fun onPageScrollStateChanged(arg0: Int) {}
        })
        binding.pageIndicator.attachTo(binding.viewPager)
    }
    private fun getItem(): Int {
        return binding.viewPager.currentItem
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}