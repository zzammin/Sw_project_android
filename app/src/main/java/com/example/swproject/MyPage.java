package com.example.swproject;


import static android.content.Intent.getIntent;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyPage extends Fragment {




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.mypage, container,false);
        Button button_1 = rootView.findViewById(R.id.button_1);
        TextView tv_name = rootView.findViewById(R.id.mypage_username);
        Bundle bundle = getArguments();
        String userName = this.getArguments() != null ? this.getArguments().getString("userName") : "";
        tv_name.setText(userName);
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MypageCompletedChal completedChalFragment = new MypageCompletedChal();
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_linear, completedChalFragment).commit();
                //메인 액티비티가 아닌 곳에서 프래그먼트 전환하려면 requireActivity()를 써줘야 한다.
            }
        });

        Button button_2 = rootView.findViewById(R.id.button_2);
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MypageCompletedChal completedChalFragment = new MypageCompletedChal();
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_linear, completedChalFragment).commit();
                //메인 액티비티가 아닌 곳에서 프래그먼트 전환하려면 requireActivity()를 써줘야 한다.
            }
        });

        Button button_3 = rootView.findViewById(R.id.button_3);
        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MypageCompletedChal completedChalFragment = new MypageCompletedChal();
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_linear, completedChalFragment).commit();
                //메인 액티비티가 아닌 곳에서 프래그먼트 전환하려면 requireActivity()를 써줘야 한다.
            }
        });


        return rootView;

    }
}
