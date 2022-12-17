package com.example.ohimix_up

import com.example.ohimix_up.HomeContainerFragment
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val companyBtn = view.findViewById<ImageButton>(R.id.company_btn)
//        val homeBtn = view.findViewById<ImageButton>(R.id.home_btn)
//        val schoolBtn = view.findViewById<ImageButton>(R.id.school_btn)
        val nounBtn = view.findViewById<ImageButton>(R.id.noun_btn)
//        val adBtn = view.findViewById<ImageButton>(R.id.ad_btn)
//        val verbBtn = view.findViewById<ImageButton>(R.id.verb_btn)

        companyBtn?.setOnClickListener { view ->
            Log.d("mytag","all button select")
            (parentFragment as HomeContainerFragment).toCompany()
        }


        nounBtn?.setOnClickListener { view ->
            Log.d("mytag","school button select")
            (parentFragment as HomeContainerFragment).toNoun()
        }

    }


}