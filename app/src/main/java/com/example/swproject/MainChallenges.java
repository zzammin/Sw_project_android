package com.example.swproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainChallenges extends Fragment {
    RecyclerViewAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_challenges,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // RecyclerView 초기화 및 설정
        RecyclerView recyclerView = view.findViewById(R.id.challenge_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        List<ListItem> itemList = new ArrayList<>();

        // 데이터 추가
        itemList.add(new ListItem("challenge 1",   1));
        itemList.add(new ListItem("challenge 2",   2));
        itemList.add(new ListItem("challenge 3",   3));
        itemList.add(new ListItem("challenge 4",   4));

        // RecyclerView 어댑터 설정
        adapter = new RecyclerViewAdapter(itemList);
        recyclerView.setAdapter(adapter);
    }

    public class ListItem {
        private String content;
        private int number;

        public ListItem(String content, int number) {
            this.content = content;
            this.number = number;
        }

        public String getContent() {
            return content;
        }

        public int getNumber() {
            return number;
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
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_challenge, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
            ListItem currentItem = itemList.get(position);
            holder.contentTextView.setText(currentItem.getContent());
            holder.numberTextView.setText(String.valueOf(currentItem.getNumber()));
            holder.clear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),"챌린지 성공!",Toast.LENGTH_LONG).show();
                    // 항목 삭제
                    int removedPosition = itemList.indexOf(currentItem);
                    itemList.remove(currentItem);
                    adapter.notifyItemRemoved(removedPosition);
                }
            });
        }

        @Override
        public int getItemCount() {
            return itemList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView contentTextView;
            TextView numberTextView;
            Button clear;

            public ViewHolder(View view) {
                super(view);
                contentTextView = view.findViewById(R.id.challenge_content);
                numberTextView = view.findViewById(R.id.challenge_number);
                clear = view.findViewById(R.id.clear_button);
            }
        }
    }
}