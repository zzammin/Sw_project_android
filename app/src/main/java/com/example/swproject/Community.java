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

import java.util.ArrayList;

public class Community extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.community,container,false);
        //뷰페이저
        ViewPager CommunityStudyPager = (ViewPager)rootView.findViewById(R.id.study_pager);
        CommunityStudyPager.setOffscreenPageLimit(3);
        StudyViewPagerAdapter adapter = new StudyViewPagerAdapter(requireActivity().getSupportFragmentManager());

        Community_Study_Fragment1 fragment1 = new Community_Study_Fragment1();
        adapter.addItem(fragment1);

        Community_Study_Fragment2 fragment2 = new Community_Study_Fragment2();
        adapter.addItem(fragment2);

        Community_Study_Fragment3 fragment3 = new Community_Study_Fragment3();
        adapter.addItem(fragment3);

        CommunityStudyPager.setAdapter(adapter);

        //게시판 button 이벤트
        //자유게시판 버튼
        Button freeBoardBtn = (Button)rootView.findViewById(R.id.freeBoardBtn);
        freeBoardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Community_Board_Free cBoardFreeFragment1 = new Community_Board_Free();
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fregment_linear, cBoardFreeFragment1).commit();
            }
        });
        // 모집 게시판 버튼
        Button collectBtn = (Button)rootView.findViewById(R.id.collectBoardBtn);
        collectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Community_Board_Collect cBoardCollectFragment = new Community_Board_Collect();
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fregment_linear, cBoardCollectFragment).commit();
            }
        });
        //정보 게시판 버튼
        Button infoBtn = (Button)rootView.findViewById(R.id.infoBoardBtn);
        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Community_Board_Info cBoardInfoFragment = new Community_Board_Info();
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fregment_linear, cBoardInfoFragment).commit();
            }
        });
        //공모전 게시판 버튼
        Button contestBtn = (Button)rootView.findViewById(R.id.contestBoardBtn);
        contestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Community_Board_Contest cBoardContestFragment = new Community_Board_Contest();
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fregment_linear, cBoardContestFragment).commit();
            }
        });
        //hot 게시판 버튼
        Button hotBtn = (Button)rootView.findViewById(R.id.hotBoardBtn);
        hotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Community_Board_Hot cBoardhotFragment = new Community_Board_Hot();
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fregment_linear, cBoardhotFragment).commit();
            }
        });

        return rootView;
    }

    class StudyViewPagerAdapter extends FragmentStatePagerAdapter{
        ArrayList<Fragment> items = new ArrayList<>();
        public StudyViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }
        public void addItem(Fragment item){
            items.add(item);
        }
        @NonNull
        @Override
        public Fragment getItem(int position) {
            return items.get(position);
        }

        @Override
        public int getCount()  {
            return items.size();
        }
    }
}

