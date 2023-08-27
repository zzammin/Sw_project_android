package com.example.swproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MypageCompletedChal extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.mypage_completed_challenge_list, container,false);
        Button backToMypageBtn = rootView.findViewById(R.id.BackToMypageBtn);
        backToMypageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyPage myPage = new MyPage();
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_linear, myPage).commit();
            }
        });
        return rootView;
    }
}
