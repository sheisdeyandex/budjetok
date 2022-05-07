package com.budjet.ok.ui.fragments.chooseexpences

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.budjet.ok.R
import com.budjet.ok.databinding.ChooseCardsFragmentBinding
import com.budjet.ok.databinding.ChooseExpencesFragmentBinding
import com.budjet.ok.oop.FabColorChange

class ChooseExpencesFragment : Fragment() {
    private var _binding: ChooseExpencesFragmentBinding? = null
    private val binding get() = _binding!!
    companion object {
        fun newInstance() = ChooseExpencesFragment()
    }

    private lateinit var viewModel: ChooseExpencesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ChooseExpencesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ChooseExpencesViewModel::class.java)
        initFabIcons()
    }
    private fun initFabIcons(){
        FabColorChange.changeColor(binding.fab,R.color.icon_active_blue,requireContext())
        FabColorChange.changeColor(binding.fabAlpha,R.color.icon_active_purple, requireContext())
        FabColorChange.changeColor(binding.fabSber,R.color.icon_active_pink, requireContext())
        FabColorChange.changeColor(binding.fabTinkoff,R.color.icon_active_sky_blue, requireContext())
    }

}