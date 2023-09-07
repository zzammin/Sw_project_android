package com.example.swproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Contest_write extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.contest_write,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button contest_previous = (Button) view.findViewById(R.id.contest2Community);
        contest_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Community_Board_Contest communityBoardContest = new Community_Board_Contest();
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_linear,communityBoardContest).commit();
            }
        });
    }
}
