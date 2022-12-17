package com.example.ohimix_up.friendRecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ohimix_up.R;

import java.util.ArrayList;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> implements Filterable {

    private ArrayList<FriendItem> mWordList = null;

    // ---------------------click이벤트 구현을 위한 코드---------------------
    public interface OnItemClickListener {
        void OnItemClicked(int position, String data);
    }
    //OnItemClickListener 참조 변수 선언
    private OnItemClickListener itemClickListener;

    //OnItemClickListener 전달 메소드
    public void setOnItemClickListener(OnItemClickListener listener){
        itemClickListener = listener;
    }
    // ---------------------click이벤트 구현을 위한 코드---------------------

    @Override
    public Filter getFilter() {
        return null;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView word1;
        TextView word1Mean;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            word1 = (TextView) itemView.findViewById(R.id.word1);
            word1Mean = (TextView) itemView.findViewById(R.id.word1Mean);
        }

        void onBind(FriendItem item) {
            word1.setText(item.getWord1());
            word1Mean.setText(item.getWord1Mean());
        }
    }



    public MyRecyclerAdapter(ArrayList<FriendItem> mFriendList) {
        this.mWordList = mFriendList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_friends_recyclerview, parent, false);
        ViewHolder vh = new ViewHolder(view);
        //---------------------onclick event ---------------------
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "";
                int position = vh.getAdapterPosition();
                if(position != RecyclerView.NO_POSITION){
                    data = vh.getItemId()+"";
                }
                itemClickListener.OnItemClicked(position, data);
            }
        });
        //--------------------- onclick event ---------------------
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(mWordList.get(position));
    }

    public void setFriendList(ArrayList<FriendItem> list) {
        this.mWordList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }

    public void filterList(ArrayList<FriendItem> filteredList){
        mWordList = filteredList;
        notifyDataSetChanged();
    }
}
