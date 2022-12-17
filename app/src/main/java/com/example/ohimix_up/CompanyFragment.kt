package com.example.ohimix_up

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CompanyFragment : Fragment() {
    val companyVocaItemList = arrayListOf<VocaListItem>()
    val companyVocaListAdapter = VocaListAdapter(companyVocaItemList, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dataList = view?.findViewById<RecyclerView>(R.id.voca_list)


        dataList?.layoutManager = LinearLayoutManager(requireContext())
        dataList?.adapter = companyVocaListAdapter

        companyVocaItemList.add(VocaListItem("금세, 금새", "금세: '금시에 준말'\n금새:물가의 높낮이"))
        companyVocaItemList.add(VocaListItem("금세, 금새", "금세: '금시에 준말'\n금새:물가의 높낮이"))
        companyVocaItemList.add(VocaListItem("금세, 금새", "금세: '금시에 준말'\n금새:물가의 높낮이"))
        companyVocaItemList.add(VocaListItem("금세, 금새", "금세: '금시에 준말'\n금새:물가의 높낮이"))
        companyVocaItemList.add(VocaListItem("금세, 금새", "금세: '금시에 준말'\n금새:물가의 높낮이"))


        companyVocaListAdapter.notifyDataSetChanged()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_company, container, false)
    }

}