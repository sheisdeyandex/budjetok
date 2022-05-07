package com.budjet.ok.ui.fragments.choosecards

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.budjet.ok.MainApplication
import com.budjet.ok.R
import com.budjet.ok.databinding.BottomSheetCurrenciesBinding
import com.budjet.ok.databinding.ChooseCardsFragmentBinding
import com.budjet.ok.interfaces.INotifyCurrencyAdapter
import com.budjet.ok.models.CurrenciesModel
import com.budjet.ok.oop.FabColorChange
import com.budjet.ok.ui.adapters.CurrenciesAdapter
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class ChooseCardsFragment : Fragment() {
    private var _binding: ChooseCardsFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: ChooseCardsViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ChooseCardsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
   private lateinit var modalBottomSheet:ModalBottomSheet
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        modalBottomSheet = ModalBottomSheet()
        viewModel = ViewModelProvider(this)[ChooseCardsViewModel::class.java]
        binding.llCurrencies.setOnClickListener { showCurrencies() }
        showCurrencies()
        initCurrencyTexts()
        initFabIcons()
        binding.btnNext.setOnClickListener {
            it.findNavController().navigate(R.id.action_chooseFragment_to_chooseExpencesFragment2)
        }
    }
    private fun initCurrencyTexts(){
        MainApplication.currency.observe(requireActivity()){
            binding.tvTitle.text=it
        }
        MainApplication.currencyIcon.observe(requireActivity()){
            binding.tvCurrency.text = MainApplication.currencyIcon.value
        }
    }
    private fun initFabIcons(){
        FabColorChange.changeColor(binding.fab,R.color.icon_active_blue,requireContext())
        FabColorChange.changeColor(binding.fabAlpha,R.color.icon_active_red, requireContext())
        FabColorChange.changeColor(binding.fabSber,R.color.icon_active_green, requireContext())
        FabColorChange.changeColor(binding.fabTinkoff,R.color.icon_active_yellow, requireContext())
    }
    private fun showCurrencies(){
        modalBottomSheet.show(childFragmentManager, ModalBottomSheet.TAG)
    }
 class ModalBottomSheet : BottomSheetDialogFragment(),INotifyCurrencyAdapter {
        private var _binding: BottomSheetCurrenciesBinding? = null
        private val binding get() = _binding!!
        lateinit var currenciesAdapter:CurrenciesAdapter
        lateinit var currenciesModel:ArrayList<CurrenciesModel>
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View{
            _binding = BottomSheetCurrenciesBinding.inflate(inflater, container, false)
            initAdapter()
            initRecyclerView()
            return binding.root
        }

        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            return object : BottomSheetDialog(requireContext()) {
                override fun onCreate(savedInstanceState: Bundle?) {
                    super.onCreate(savedInstanceState)
                    dialog?.setOnShowListener {
                        binding.coordinator.let { view ->
                            val behavior = (dialog as BottomSheetDialog).behavior
                            view.setupFullHeight()
                            behavior.apply {
                                isHideable =true
                                skipCollapsed = true
                                peekHeight = binding.coordinator.height
                                state = BottomSheetBehavior.STATE_EXPANDED
                            }
                        }
                    }
                }
            }}
    fun View.setupFullHeight(maxHeight: Double = 0.9) {
            val displayMetrics = context?.resources?.displayMetrics
            val height = displayMetrics?.heightPixels
            val maximalHeight = (height?.times(maxHeight))?.toInt()
            val layoutParams = this.layoutParams
            maximalHeight?.let {
                layoutParams.height = it
            }
            this.layoutParams = layoutParams
        }
    private fun addCurrencies(){
        currenciesModel.add(CurrenciesModel("RUB - Российский рубль","₽"))
        currenciesModel.add(CurrenciesModel("USD - Доллар США","$"))
        currenciesModel.add(CurrenciesModel("EUR - Евро","€"))
        currenciesModel.add(CurrenciesModel("GBP - Фунт стерлингов","£"))
        currenciesModel.add(CurrenciesModel("UAH - Украинская гривна","₴"))
        currenciesModel.add(CurrenciesModel("KZT - Казахстанский тенге","₸"))
        currenciesModel.add(CurrenciesModel("BYN - Белорусский рубль","Br"))
        currenciesModel.add(CurrenciesModel("AZN - Азербайджанский манат","₼"))
        currenciesModel.add(CurrenciesModel("UZS - Узбекский сум","сўм"))
        currenciesModel.add(CurrenciesModel("AMD - Армянский драм","֏"))
        currenciesModel.add(CurrenciesModel("RON - Российский рубль","₽"))
        currenciesModel.add(CurrenciesModel("RUB - Российский рубль","₽"))
        currenciesModel.add(CurrenciesModel("RUB - Российский рубль","₽"))
        currenciesModel.add(CurrenciesModel("RUB - Российский рубль","₽"))
        currenciesModel.add(CurrenciesModel("RUB - Российский рубль","₽"))
        currenciesModel.add(CurrenciesModel("RUB - Российский рубль","₽"))
        currenciesModel.add(CurrenciesModel("RUB - Российский рубль","₽"))
        currenciesModel.add(CurrenciesModel("RUB - Российский рубль","₽"))
        currenciesModel.add(CurrenciesModel("RUB - Российский рубль","₽"))
        currenciesModel.add(CurrenciesModel("RUB - Российский рубль","₽"))
        currenciesModel.add(CurrenciesModel("RUB - Российский рубль","₽"))
        currenciesModel.add(CurrenciesModel("RUB - Российский рубль","₽"))
        currenciesModel.add(CurrenciesModel("RUB - Российский рубль","₽"))
        currenciesModel.add(CurrenciesModel("RUB - Российский рубль","₽"))
        currenciesModel.add(CurrenciesModel("RUB - Российский рубль","₽"))
        currenciesModel.add(CurrenciesModel("RUB - Российский рубль","₽"))
        currenciesModel.add(CurrenciesModel("RUB - Российский рубль","₽"))
        currenciesModel.add(CurrenciesModel("RUB - Российский рубль","₽"))
        currenciesModel.add(CurrenciesModel("RUB - Российский рубль","₽"))
        currenciesModel.add(CurrenciesModel("RUB - Российский рубль","₽"))
        currenciesModel.add(CurrenciesModel("RUB - Российский рубль","₽"))
        currenciesModel.add(CurrenciesModel("RUB - Российский рубль","₽"))
        currenciesModel.add(CurrenciesModel("RUB - Российский рубль","₽"))
        currenciesModel.add(CurrenciesModel("RUB - Российский рубль","₽"))
        currenciesModel.add(CurrenciesModel("RUB - Российский рубль","₽"))
        currenciesModel.add(CurrenciesModel("RUB - Российский рубль","₽"))
    }
    companion object {
            const val TAG = "ModalBottomSheet"
        }
    private fun initAdapter(){
        currenciesModel = ArrayList()
        addCurrencies()
        currenciesAdapter = CurrenciesAdapter(requireContext(),this)
        currenciesAdapter.differ.submitList(currenciesModel)
        }
    private fun initRecyclerView(){
        binding.rvCurrencies.layoutManager=
                LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.VERTICAL,
                    false
                )
        binding.rvCurrencies.adapter = currenciesAdapter

        }

     override fun notifyAdapter() {
         dismiss()
     }
 }
    }