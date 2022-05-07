package com.budjet.ok.ui.adapters

import android.content.Context
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.budjet.ok.MainApplication
import com.budjet.ok.databinding.ItemCurrenciesBinding
import com.budjet.ok.interfaces.INotifyCurrencyAdapter
import com.budjet.ok.models.CurrenciesModel

class CurrenciesAdapter (private var context: Context,var iNotifyCurrencyAdapter: INotifyCurrencyAdapter):RecyclerView.Adapter<CurrenciesAdapter.MainViewHolder>() {
    private val differCallback = object : DiffUtil.ItemCallback<CurrenciesModel>() {
        override fun areItemsTheSame(oldItem: CurrenciesModel, newItem: CurrenciesModel): Boolean {
            return oldItem.currencyText == newItem.currencyText&&oldItem.currencyIcon==newItem.currencyIcon
        }

        override fun areContentsTheSame(oldItem: CurrenciesModel, newItem: CurrenciesModel): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainViewHolder {
        val binding = ItemCurrenciesBinding.inflate(LayoutInflater.from(context),parent,false)
        binding.llCurrencies.setOnClickListener {
            iNotifyCurrencyAdapter.notifyAdapter()
            MainApplication.currency.postValue(binding.tvCurrencies.text.toString())
            MainApplication.currencyIcon.postValue(binding.tvCurrenciesIcon.text.toString())
        }
        return MainViewHolder(binding)
    }

    class MainViewHolder(private val binding: ItemCurrenciesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(currencies: CurrenciesModel) {
            binding.tvCurrencies.text = currencies.currencyText
            binding.tvCurrenciesIcon.text = currencies.currencyIcon
        }

    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val foodItem = differ.currentList[position]
        holder.bind(foodItem)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}