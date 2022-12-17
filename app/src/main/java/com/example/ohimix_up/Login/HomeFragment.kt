//package com.example.ohimix_up.Login
//
//import android.content.Context
//import android.content.Intent
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageButton
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.ohimix_up.CompanyActivity
//import com.example.ohimix_up.R
//import com.example.ohimix_up.sliderAdapter
//
//class HomeFragment : Fragment() {
//    //    private lateinit var mainactivity: MainActivity
//    lateinit var applicationContext: Context
////    lateinit var alarmFragmentBinding: ActivityFragment1Binding
//    lateinit var sliderAdapter: sliderAdapter
//    lateinit var recyclerview: RecyclerView
////    lateinit var alarmRecyclerView: RecyclerView
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val view = inflater.inflate(R.layout.fragment_home, container, false)
//        val companyBtn: ImageButton = view.findViewById(R.id.company_btn)
//        companyBtn.setOnClickListener {
//            activity?.let {
//                val intent = Intent(context, CompanyActivity::class.java)
////               intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION); //애니메이션 생략
//                startActivity(intent)
//            }
//        }
//
//        val list = listOf(
//            AlarmItem("졸업식","9시 30분"),
//            AlarmItem("학교 가자","6시 45분"),
//            AlarmItem("hi","1시30분"),
//        )
//        recyclerview = view.findViewById(R.id.Alarm_RecyclerView)
//        recyclerview.layoutManager = LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false)
//        recyclerview.setHasFixedSize(true)
////        alarmRecyclerView.setLayoutManager(LinearLayoutManager(view.context))
//        recyclerview.adapter = sliderAdapter(list)
//        sliderAdapter = sliderAdapter(list)
//
////        alarmRecyclerView.adapter = AlarmAdapter()
//
////      스와이프　삭제 메서드 구현
////        attachItemTouchHelperToAdapter()
//
//        return view
//    }
//}
//
////    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
////        super.onViewCreated(view, savedInstanceState)
////
////        val companyBtn = view.findViewById<ImageButton>(R.id.company_btn)
////        val homeBtn = view.findViewById<ImageButton>(R.id.home_btn)
////        val schoolBtn = view.findViewById<ImageButton>(R.id.school_btn)
////        val nounBtn = view.findViewById<ImageButton>(R.id.noun_btn)
////        val adBtn = view.findViewById<ImageButton>(R.id.ad_btn)
////        val verbBtn = view.findViewById<ImageButton>(R.id.verb_btn)
////
////        companyBtn?.setOnClickListener { view ->
//////            mainactivity.fragmentIntent()
////            Log.d("mytag","all button select")
//////            (parentFragment as HomeContainerFragment).toCompany()
////        }
////
////
////        nounBtn?.setOnClickListener { view ->
////            Log.d("mytag","school button select")
////            (parentFragment as HomeContainerFragment).toNoun()
////        }
////
////    }
////
////
////}