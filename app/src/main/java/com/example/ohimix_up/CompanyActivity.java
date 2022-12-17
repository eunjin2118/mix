package com.example.ohimix_up;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.widget.Button;

import com.example.ohimix_up.friendRecyclerView.FriendItem;
import com.example.ohimix_up.friendRecyclerView.MyRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CompanyActivity extends AppCompatActivity {
    RecyclerView voca_list;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private MyRecyclerAdapter userAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<FriendItem> arrayList;
    String datas[][] = {{"결재(決裁)",
            "랫사람이 올린 안건을 상관이 헤아려 승인함.",
            "결제(決濟)",
            "①결정하여 끝냄. ②증권 또는 대금의 수불(受拂)에 의하여 대차(貸借)를 청산하는 일."
            },
            {"모시다 ",
                    "'①(손윗사람을) 가까이서 받들다. ②(손윗사람을) 받들어 같이 어떤 곳으로 가거나 오다. ③어떤 곳에 자리잡게 하다. ④의례를 지내다.",
                    "뫼시다",
                    "'모시다'의 옛말."
            },
            {"보전",
                    "온전하도록 보호함. *문화재를 보전하자.",
                    "보존",
                    "①잘 건사하여 잃지 아니하도록 함. ②원상을 잘 유지함."
            },
            {"얼씬거리다",
                    "떠나지 않고 눈앞에 자꾸 나타나다.",
                    "얼찐거리다",
                    "앞에서 가까이 돌며 몹시 아첨하는 태도를 보이다. >알찐거리다."
            },
            {"매기다",
                    "차례, 값, 등수, 점수 등을 정한다",
                    "메기다",
                    "노래를 주고 받을 때 한 편이 먼저 부르다"
            }};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);
        voca_list = findViewById(R.id.voca_list);
//        recyclerView.setHasFixedSize(true); //리사이클러뷰 기존성능 강화
        layoutManager = new LinearLayoutManager(getApplicationContext());
        voca_list.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>(); //User객체를 담을 arraylist
        for (int i = 0; i < 5; i++) {
            arrayList.add(new FriendItem(datas[i][0]+datas[i][2], datas[i][1]+datas[i][3]));
        }
        userAdapter = new MyRecyclerAdapter(arrayList);
        voca_list.setAdapter(userAdapter); // 리사이클러뷰에 어뎀터 넘기기


    }
}