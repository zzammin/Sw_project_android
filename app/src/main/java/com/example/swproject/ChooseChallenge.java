package com.example.swproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class ChooseChallenge extends Fragment {
    ViewPager2 viewPager2;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.choose_challenge, container,false);
        return rootView;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView plus = (ImageView) view.findViewById(R.id.plus_button);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // MainActivity에게 프래그먼트 변경 요청을 보냄
                FragmentChangeListener listener = (FragmentChangeListener) getActivity();
                if (listener != null) {
                    listener.onFragmentChange();
                }
            }
        });

        // RecyclerView 초기화 및 설정
        RecyclerView recyclerView = view.findViewById(R.id.challenge_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        List<ListItem> itemList = new ArrayList<>();

        // 데이터 추가
        itemList.add(new ListItem("challenge 1"));
        itemList.add(new ListItem("challenge 2"));
        itemList.add(new ListItem("challenge 3"));
        itemList.add(new ListItem("challenge 4"));

        // RecyclerView 어댑터 설정
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(itemList);
        recyclerView.setAdapter(adapter);
    }

    public class ListItem {
        private String choose;

        public ListItem(String choose) {
            this.choose = choose;
        }

        public String getContent() {
            return choose;
        }
    }

    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
        private List<ListItem> itemList;

        public RecyclerViewAdapter(List<ListItem> itemList) {
            this.itemList = itemList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_choose, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
            ListItem currentItem = itemList.get(position);
            holder.chooseTextView.setText(currentItem.getContent());
        }

        @Override
        public int getItemCount() {
            return itemList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView chooseTextView;

            public ViewHolder(View view) {
                super(view);
                chooseTextView = view.findViewById(R.id.choose_challenge);
            }
        }
    }
}