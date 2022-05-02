package com.budjet.ok.ui.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.budjet.ok.R
import com.budjet.ok.ui.fragments.onboarding.onboardinginside.OnBoardingInsideFragment

class OnBoardingAdapter(
    fragmentActivity: FragmentActivity,
    private val context: Context
) : FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> OnBoardingInsideFragment.newInstance(
                context.resources.getString(R.string.description_onboarding_1),
                R.drawable.onboarding_image1
            )
            1 -> OnBoardingInsideFragment.newInstance(
                context.resources.getString(R.string.description_onboarding_2),
                R.drawable.onboarding_image2
            )
            2 -> OnBoardingInsideFragment.newInstance(
                context.resources.getString(R.string.description_onboarding_3),
                R.drawable.onboarding_image3
            )

            else -> OnBoardingInsideFragment.newInstance(
                context.resources.getString(R.string.description_onboarding_4),
                R.drawable.onboarding_image4
            )
        }
    }

    override fun getItemCount(): Int {
        return 3
    }
}