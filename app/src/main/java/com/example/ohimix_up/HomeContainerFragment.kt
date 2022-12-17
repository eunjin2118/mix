package com.example.ohimix_up

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ohimix_up.HomeFragment
import com.example.ohimix_up.R
import com.example.ohimix_up.CompanyFragment
import com.example.ohimix_up.NounFragment

class HomeContainerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_container, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        childFragmentManager.beginTransaction().add(R.id.container, HomeFragment()).commit()
    }

//    fun changeFragment(fragment: Fragment) {
//        childFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
//    }


    fun toCompany() {
        childFragmentManager.beginTransaction().replace(R.id.container, CompanyFragment()).commit()
    }
    fun toNoun() {
        childFragmentManager.beginTransaction().replace(R.id.container, NounFragment()).commit()
    }
}