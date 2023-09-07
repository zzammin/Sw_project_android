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
                // EditText에서 입력된 값을 가져옴
                EditText titleEditText = getView().findViewById(R.id.free_title);
                EditText contentEditText = getView().findViewById(R.id.free_context);
                TextView userId = getView().findViewById(R.id.free_userid);
                String title = titleEditText.getText().toString();
                String content = contentEditText.getText().toString();
                String userid = userId.getText().toString();
                Log.d("title",":"+title);
                Log.d("title",":"+content);
                Log.d("title",":"+userid);

                // 새로운 ListItem 생성하고 데이터 설정
                if (communityBoardFree.itemList != null) {
                    int size = communityBoardFree.itemList.size();
                    int number = size + 1;

                    Community_Board_Free.ListItem listItem = communityBoardFree.new ListItem(title, content, userid, number);

                    // itemList에 추가
                    communityBoardFree.itemList.add(listItem);
                }else{
                    int number = 0;
                    Community_Board_Free.ListItem listItem = communityBoardFree.new ListItem(title, content, userid, number);

                    // itemList에 추가
                    communityBoardFree.itemList.add(listItem);
                }

                // Community_Board_Free 프래그먼트로 이동
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_linear, communityBoardFree)
                        .commit();
            }
        });

    }
}
