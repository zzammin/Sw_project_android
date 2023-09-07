package com.example.swproject;

import android.app.LauncherActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Community_Board_Free extends Fragment {
    public List<ListItem> itemList = new ArrayList<>();
    private String title;
    private String content;
    private String userid;
    private int number;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.community_board_free, container, false);
        Button backBtn = (Button) rootView.findViewById(R.id.free2Community);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Community community = new Community();
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_linear, community).commit();
            }
        });
        return rootView;
    }

    public void setData(String title, String content, String userid, int number) {
        this.title = title;
        this.content = content;
        this.userid = userid;
        this.number = number;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button freeWriteButton = view.findViewById(R.id.free_write_button);
        freeWriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Free_write freeWrite = new Free_write();
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_linear, freeWrite).commit();
            }
        });

        // RecyclerView 초기화 및 설정
        RecyclerView recyclerView = view.findViewById(R.id.free_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        // 데이터 추가
        itemList.add(new ListItem("Title 1", "Content 1", "zzam", 1));
        itemList.add(new ListItem("Title 2", "Content 2", "yeon", 2));
        itemList.add(new ListItem("Title 3", "Content 3", "soo", 3));
        itemList.add(new ListItem(title,content,userid,number));

        // RecyclerView 어댑터 설정
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(itemList);
        recyclerView.setAdapter(adapter);

    }

    private void changeFragmentWithData(String title, String content, String userid, int number) {
        // 데이터를 담은 Bundle 생성
        Bundle bundle = new Bundle();
        bundle.putString("post1", title);
        bundle.putString("post2", content);
        bundle.putString("post3", userid);
        //bundle.putInt("number", number);

        // Fragment 인스턴스 생성 및 Bundle 전달
        Post_free post_free = new Post_free();
        post_free.setArguments(bundle);

        // Fragment 변경
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_linear, post_free)
                .addToBackStack(null)
                .commit();
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
        ListItem currentItem;

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
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            final int itemPosition = position;
            currentItem = itemList.get(itemPosition);
            holder.titleTextView.setText(currentItem.getTitle());
            holder.contentTextView.setText(currentItem.getContent());
            holder.useridTextView.setText(currentItem.getUserId());
            holder.numberTextView.setText(String.valueOf(currentItem.getNumber()));

            // RecyclerView item의 Click 이벤트
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    currentItem = itemList.get(itemPosition);
                    String title = currentItem.getTitle();
                    String content = currentItem.getContent();
                    String userid = currentItem.getUserId();
                    int number = currentItem.getNumber();
                    changeFragmentWithData(title, content, userid, number);
                }
            });

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

