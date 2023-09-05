package com.example.swproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Community_Board_Collect extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.community_board_collect,container,false);
        Button backBtn = (Button)rootView.findViewById(R.id.collect2Community);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Community community = new Community();
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_linear,community).commit();
            }
        });
        return rootView;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button collectWriteButton = (Button) view.findViewById(R.id.collect_write_button);
        collectWriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collect_write collectWrite = new Collect_write();
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_linear,collectWrite).commit();
            }
        });

        // RecyclerView 초기화 및 설정
        RecyclerView recyclerView = view.findViewById(R.id.collect_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        List<ListItem> itemList = new ArrayList<>();

        // 데이터 추가
        itemList.add(new ListItem("Title 1", "Content 1", "zzam", 1));
        itemList.add(new ListItem("Title 2", "Content 2", "yeon", 2));
        itemList.add(new ListItem("Title 3", "Content 3", "soo", 3));

        // RecyclerView 어댑터 설정
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(itemList);
        recyclerView.setAdapter(adapter);
    }

    public class ListItem {
        private String title;
        private String content;
        private String userid;
        private int number;

        public ListItem(String title, String content, String userid, int number) {
            this.title = title;
            this.content = content;
            this.userid = userid;
            this.number = number;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public String getUserId() {
            return userid;
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
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
            ListItem currentItem = itemList.get(position);
            holder.titleTextView.setText(currentItem.getTitle());
            holder.contentTextView.setText(currentItem.getContent());
            holder.useridTextView.setText(currentItem.getUserId());
            holder.numberTextView.setText(String.valueOf(currentItem.getNumber()));
        }

        @Override
        public int getItemCount() {
            return itemList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView titleTextView;
            TextView contentTextView;
            TextView useridTextView;
            TextView numberTextView;

            public ViewHolder(View view) {
                super(view);
                titleTextView = view.findViewById(R.id.post_title);
                contentTextView = view.findViewById(R.id.post_content);
                useridTextView = view.findViewById(R.id.post_userid);
                numberTextView = view.findViewById(R.id.post_number);
            }
        }
    }
}
