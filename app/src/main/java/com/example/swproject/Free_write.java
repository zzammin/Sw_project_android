package com.example.swproject;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

public class Free_write extends Fragment {
    Community_Board_Free communityBoardFree = new Community_Board_Free();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.free_write,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button free_previous = (Button) view.findViewById(R.id.free2Community);
        free_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Community_Board_Free communityBoardFree = new Community_Board_Free();
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_linear,communityBoardFree).commit();
            }
        });



        Button completeButton = view.findViewById(R.id.complete_button);
        completeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText titleEditText = (EditText) view.findViewById(R.id.free_title);
                Log.d("title",":"+titleEditText);
                EditText contentEditText = (EditText) view.findViewById(R.id.free_context);
                TextView userIdTextView = (TextView) view.findViewById(R.id.free_userid);

                String title = titleEditText.getText().toString(); // EditText에서 텍스트 추출
                Log.d("title1",":"+title);
                String content = contentEditText.getText().toString(); // EditText에서 텍스트 추출
                String userId = userIdTextView.getText().toString(); // TextView에서 텍스트 추출

                int size = communityBoardFree.itemList.size();
                int number = size + 1;

                Bundle bundle = new Bundle();
                bundle.putString("post1", title); // 추출된 제목을 번들에 넣음
                bundle.putString("post2", content); // 추출된 내용을 번들에 넣음
                bundle.putString("post3", userId); // 추출된 사용자 ID를 번들에 넣음
                bundle.putInt("post4",number); // 추출된 게시글 number를 번들에 넣음

                // getArguments() 메서드로 현재 프래그먼트의 번들을 가져와서 수정
                Bundle currentFragmentArgs = getArguments();
                if (currentFragmentArgs == null) {
                    currentFragmentArgs = new Bundle();
                }
                currentFragmentArgs.putAll(bundle);

                // 현재 프래그먼트에 번들 설정
                setArguments(currentFragmentArgs);

                // Community_Board_Free 프래그먼트로 이동
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_linear, communityBoardFree)
                        .commit();
            }
        });

    }
}
