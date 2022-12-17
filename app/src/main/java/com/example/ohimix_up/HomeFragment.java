package com.example.ohimix_up;

import android.content.ClipData;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.google.firebase.storage.StorageReference;
import java.io.File;
import java.util.ArrayList;

// udpate
public class HomeFragment extends Fragment {
    Button StopRecording;
    RecyclerView SlideRecyclerView;
    private ArrayList<SlideItem> mSlideList;
    private SlideItem SlideItem;
    sliderAdapter mySliderAdapter;
    Button btnDownload;
    ImageButton companyBtn, homeBtn, noneBtn, verbBtn;
    String datas[][] = {{"가게",
            "물건 파는 집. 상점.",
            "가계",
            "①집안 살림의 수입·지출. 살림살이. ②생계(生計). 과일가게 운영으로 대가족의 가계를 꾸려가기가 좀 벅차다."},
            {"금세",
                    "'금시에'의 준말. 떡 한 접시를 금세 먹어 치웠다.",
                    "금새",
                    "물가의 높낮이 정도끝물 수박이라 금새가 형편없이 낮다."
            },
            {"노름",
                    "돈 따위를 걸고 따먹기를 하는 내기",
                    "놀음",
                    "여럿이 즐겁게 노는 일"
            },
            {"단박에",
                    "그 자리에서. *그가 나를 단박 알아보았다",
                    "대번에",
                    "서슴지 않고 단숨에"
            },
            {"매기다",
                    "차례, 값, 등수, 점수 등을 정한다",
                    "메기다",
                    "노래를 주고 받을 때 한 편이 먼저 부르다"
            },
            {"선뜩",
                    "갑자기 놀라거나 찬 느낌을 받는 모양",
                    "선뜻",
                    "거침없이 가볍고 빠르고 시원스런 모양"
            },
            {"왠지",
                    "'왜인지'의 준말",
                    "웬",
                    "[관]어찌 된. 어떤. 어떠한."
            },
            {"처지다",
                    "①아래로 늘어져 내려가다 ②뒤떨어져 남다.",
                    "쳐지다",
                    "①발, 휘장 따위가 걸려지다 ②그물 따위가 펴버 벌려져 있다."
            },
            {"특색",
                    "보통 것과 다른 점",
                    "특징",
                    "다른 것에 비겨서 특별히 눈에 띄는 점"
            },
            {"혼돈",
                    "사물의 구별이 확연하지 않고 모호한 상태",
                    "혼동",
                    "①섞여 하나가 됨. ②뒤섞어 보거나 잘못 판단함."}};



    public HomeFragment() {
        // Required empty public constructor
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        SlideRecyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        companyBtn = (ImageButton) v.findViewById(R.id.company_btn);
        homeBtn = (ImageButton) v.findViewById(R.id.home_btn);
        noneBtn = (ImageButton) v.findViewById(R.id.none_btn);
        verbBtn = (ImageButton) v.findViewById(R.id.verb_btn);
        //////////////////// recyclerview
        SlideRecyclerView.setHasFixedSize(true);
//        SlideRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        SlideRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));
        mSlideList = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            mSlideList.add(new SlideItem(datas[i][0], datas[i][1],datas[i][2], datas[i][3]));
        }
        mySliderAdapter = new sliderAdapter(mSlideList);
        SlideRecyclerView.setAdapter(mySliderAdapter);

        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(SlideRecyclerView);
        //////////////////// recyclerview

        companyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CompanyActivity.class);
                startActivity(intent);
            }
        });

        return v; // 반드시 추가

    }
}
