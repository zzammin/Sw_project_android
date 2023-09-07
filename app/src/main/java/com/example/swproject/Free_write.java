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

                // 새로운 게시물을 Community_Board_Free로 전달
                sendDataToCommunityBoardFree(title, content, userId, number); // 0은 새 게시물 번호를 의미합니다.

            }
        });

    }

    public void sendDataToCommunityBoardFree(String title, String content, String userId, int number) {
        communityBoardFree.setData(title, content, userId, number);

        // Community_Board_Free 프래그먼트로 이동
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_linear, communityBoardFree)
                .commit();
    }
}
