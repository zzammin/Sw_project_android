package com.example.swproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Community_Board_Collect extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.community_board_collect,container,false);
        Button backBtn = (Button)rootView.findViewById(R.id.collect2Community);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Community community = new Community();
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_linear,community).commit();
            }
        });
        return rootView;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button collectWriteButton = (Button) view.findViewById(R.id.collect_write_button);
        collectWriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collect_write collectWrite = new Collect_write();
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_linear,collectWrite).commit();
            }
        });

    }
}
