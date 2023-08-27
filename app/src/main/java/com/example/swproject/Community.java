package com.example.swproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class Community extends Fragment {
    ViewPager2 communityStudyPager;
    StudyViewPagerAdapter adapter;
    ArrayList<Fragment> study_items = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.community,container,false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //게시판 button 이벤트
        //자유게시판 버튼
        Button freeBoardBtn = (Button)view.findViewById(R.id.freeBoardBtn);
        freeBoardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Community_Board_Free cBoardFreeFragment1 = new Community_Board_Free();
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fregment_linear, cBoardFreeFragment1).commit();
            }
        });
        // 모집 게시판 버튼
        Button collectBtn = (Button)view.findViewById(R.id.collectBoardBtn);
        collectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Community_Board_Collect cBoardCollectFragment = new Community_Board_Collect();
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fregment_linear, cBoardCollectFragment).commit();
            }
        });
        //정보 게시판 버튼
        Button infoBtn = (Button)view.findViewById(R.id.infoBoardBtn);
        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Community_Board_Info cBoardInfoFragment = new Community_Board_Info();
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fregment_linear, cBoardInfoFragment).commit();
            }
        });
        //공모전 게시판 버튼
        Button contestBtn = (Button)view.findViewById(R.id.contestBoardBtn);
        contestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Community_Board_Contest cBoardContestFragment = new Community_Board_Contest();
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_linear, cBoardContestFragment).commit();
            }
        });
        //hot 게시판 버튼
        Button hotBtn = (Button)view.findViewById(R.id.hotBoardBtn);
        hotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Community_Board_Hot cBoardhotFragment = new Community_Board_Hot();
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_linear, cBoardhotFragment).commit();
            }
        });
        //뷰페이저
        communityStudyPager = (ViewPager2)view.findViewById(R.id.study_pager);
        communityStudyPager.setOffscreenPageLimit(3);
        adapter = new StudyViewPagerAdapter(this);

        if(study_items.size()==0) {
            Community_Study_Fragment1 fragment1 = new Community_Study_Fragment1();
            adapter.addItem(fragment1);

            Community_Study_Fragment2 fragment2 = new Community_Study_Fragment2();
            adapter.addItem(fragment2);

            Community_Study_Fragment3 fragment3 = new Community_Study_Fragment3();
            adapter.addItem(fragment3);
        }

        communityStudyPager.setAdapter(adapter);
    }

    class StudyViewPagerAdapter extends FragmentStateAdapter {
        public StudyViewPagerAdapter(@NonNull Fragment fragment) {
            super(fragment.requireActivity());
        }
        public void addItem(Fragment item){
            study_items.add(item);
        }
        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return study_items.get(position);
        }

        @Override
        public int getItemCount()  {
            return study_items.size();
        }
    }
}

