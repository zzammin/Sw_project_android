package com.example.swproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Collect_write extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.collect_write,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button collect_previous = (Button) view.findViewById(R.id.collect2Community);
        collect_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Community_Board_Collect communityBoardCollect = new Community_Board_Collect();
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_linear,communityBoardCollect).commit();
            }
        });
    }
}
