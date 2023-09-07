package com.example.swproject;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
public class Ranking extends Fragment{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Bundle에서 userName 가져오고 로그에 출력
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.ranking, container, false);
        TextView tv_name = rootView.findViewById(R.id.ranking_name);
        Bundle bundle_ranking = getArguments();
        String userName = bundle_ranking != null ? bundle_ranking.getString("userName", "") : "에러";
        Log.d("ranking", "Received userName: " + userName);

        // userName을 TextView에 설정
        tv_name.setText(userName);

        return inflater.inflate(R.layout.ranking,container,false);
    }
}
