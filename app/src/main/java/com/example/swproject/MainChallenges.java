package com.example.swproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class MainChallenges extends Fragment {
    private Button data;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_challenges,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<String> dataList = new ArrayList<>(); // 실제 데이터로 대체
        ListAdapter adapter = new ListAdapter(dataList);
        ListView listView = view.findViewById(R.id.challenge_list); // ListView의 ID로 대체
        listView.setAdapter(adapter);
        data = view.findViewById(R.id.data);
        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),show_challenge.class);
                startActivity(intent);
            }
        });

    }

    public class ListAdapter extends BaseAdapter{
        private List<String> data;
        private int maxItems = 4;

        public ListAdapter(List<String> data){
            this.data=data;
        }
        @Override
        public int getCount() {
            // 어댑터의 getCount() 메서드를 통해 항목 수를 제한
            return Math.min(data.size(), maxItems);
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // 항목 레이아웃을 인플레이트하고 data.get(position)에서 데이터를 채웁니다.
            return convertView;
        }

    }
}
