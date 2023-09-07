package com.example.swproject;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Post_collect extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.post_collect,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // getArguments 메서드를 사용하여 번들 데이터 추출
        Bundle args = getArguments();
        if (args != null) {
            String title = args.getString("post1");
            Log.d("title",":"+title);
            String content = args.getString("post2");
            String userid = args.getString("post3");
            // int number = args.getInt("number");

            TextView post1 = (TextView) view.findViewById(R.id.post1);
            post1.setText(title);
            TextView post2 = (TextView) view.findViewById(R.id.post2);
            post2.setText(content);
            TextView post3 = (TextView) view.findViewById(R.id.post3);
            post3.setText(userid);
        }

        Button previous_post = view.findViewById(R.id.post2Collect);
        previous_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Community_Board_Collect collect_board = new Community_Board_Collect();
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_linear, collect_board).commit();
            }
        });
    }
}
