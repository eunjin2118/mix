package com.example.ohimix_up

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CommunityFragment : Fragment() {
    val postItemList = arrayListOf<PostListItem>()
    val postListAdapter = PostListAdapter(postItemList, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_community, container, false)
        super.onCreate(savedInstanceState)

        val dataList = view?.findViewById<RecyclerView>(R.id.post_list)

        dataList?.layoutManager = LinearLayoutManager(requireContext())
        dataList?.adapter = postListAdapter

        postItemList.add(PostListItem( "mary","2022-12-17","하아이이이"))
        postListAdapter.notifyDataSetChanged()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




    }
}