package com.example.swproject;

import android.app.LauncherActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class Community_Board_Free extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.community_board_free,container,false);
        Button backBtn = (Button)rootView.findViewById(R.id.free2Community);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Community community = new Community();
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_linear,community).commit();
            }
        });
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button freeWriteButton = (Button) view.findViewById(R.id.free_write_button);
        freeWriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Free_write freeWrite = new Free_write();
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_linear,freeWrite).commit();
            }
        });

        // 리스트뷰의 데이터가 들어갈 빈 리스트 만듦
        List<ListItem> itemList = new ArrayList<>();

        // 리스트뷰의 데이터 추가
        ListItem item1 = new ListItem("Title 1","Content 1","zzam",1);
        ListItem item2 = new ListItem("Title 2","Content 2","yeon",2);
        ListItem item3 = new ListItem("Title 3","Content 3","soo",3);

        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);


        ListViewAdapter adapter = new ListViewAdapter(getContext(),itemList);
        ListView listView = (ListView) view.findViewById(R.id.free_listview);

        listView.setAdapter(adapter);

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

    public class ListViewAdapter extends BaseAdapter {
        private Context context;
        private List<ListItem> itemList;

        public ListViewAdapter(Context context, List<ListItem> itemList) {
            this.context = context;
            this.itemList = itemList;
        }

        @Override
        public int getCount() {
            return itemList.size();
        }

        @Override
        public Object getItem(int position) {
            return itemList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            view = LayoutInflater.from(context).inflate(R.layout.listview_item, parent, false);

            TextView titleTextView = view.findViewById(R.id.post_title);
            TextView contentTextView = view.findViewById(R.id.post_content);
            TextView useridTextView = view.findViewById(R.id.post_userid);
            TextView numberTextView = view.findViewById(R.id.post_number);

            ListItem currentItem = itemList.get(position);
            titleTextView.setText(currentItem.getTitle());
            contentTextView.setText(currentItem.getContent());
            useridTextView.setText(currentItem.getUserId());
            numberTextView.setText(String.valueOf(currentItem.getNumber()));

            return view;
        }
    }


}
