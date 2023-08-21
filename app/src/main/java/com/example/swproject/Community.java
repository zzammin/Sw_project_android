package com.example.swproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

