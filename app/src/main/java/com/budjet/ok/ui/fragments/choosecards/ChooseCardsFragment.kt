package com.budjet.ok.ui.fragments.choosecards

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.budjet.ok.R
import com.budjet.ok.databinding.BottomSheetCurrenciesBinding
import com.budjet.ok.databinding.ChooseCardsFragmentBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class ChooseCardsFragment : Fragment() {
    private var _binding: ChooseCardsFragmentBinding? = null
    private val binding get() = _binding!!
    companion object {
        fun newInstance() = ChooseCardsFragment()
    }
    private lateinit var viewModel: ChooseCardsViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ChooseCardsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
    lateinit var modalBottomSheet:ModalBottomSheet
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         modalBottomSheet = ModalBottomSheet()
        viewModel = ViewModelProvider(this)[ChooseCardsViewModel::class.java]
        binding.llCurrencies.setOnClickListener { showCurrencies() }
        showCurrencies()
    }
    private fun showCurrencies(){
        modalBottomSheet.show(childFragmentManager, ModalBottomSheet.TAG)
    }
    class ModalBottomSheet : BottomSheetDialogFragment() {
        private var _binding: BottomSheetCurrenciesBinding? = null
        private val binding get() = _binding!!
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View{
            _binding = BottomSheetCurrenciesBinding.inflate(inflater, container, false)

            val offsetFromTop = 200
            (dialog as? BottomSheetDialog)?.behavior?.apply {
                isFitToContents = false
                expandedOffset = offsetFromTop
                state = BottomSheetBehavior.STATE_EXPANDED
            }
            val mBottomSheetBehaviorCallback: BottomSheetCallback = object : BottomSheetCallback() {
                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                        dismiss()
                    }
                }
                override fun onSlide(bottomSheet: View, slideOffset: Float) {}
            }
            val params =
                (requireView().parent as View).layoutParams as CoordinatorLayout.LayoutParams
            val behavior = params.behavior

            if (behavior != null && behavior is BottomSheetBehavior<*>) {
                behavior.addBottomSheetCallback(mBottomSheetBehaviorCallback)
            }
            return binding.root
        }
        companion object {
            const val TAG = "ModalBottomSheet"
        }
    }


}