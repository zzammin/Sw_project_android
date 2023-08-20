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

public class Market extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.market,container,false);
        ViewPager pager = (ViewPager)rootView.findViewById(R.id.Today_Sale_pager);
        pager.setOffscreenPageLimit(3);
        TodaySaleViewPagerAdapter adapter = new TodaySaleViewPagerAdapter(requireActivity().getSupportFragmentManager());

        Market_Sale_Fragment1 fragment1 = new Market_Sale_Fragment1();
        adapter.addItem(fragment1);

        Market_Sale_Fragment2 fragment2 = new Market_Sale_Fragment2();
        adapter.addItem(fragment2);

        Market_Sale_Fragment3 fragment3 = new Market_Sale_Fragment3();
        adapter.addItem(fragment3);

        pager.setAdapter(adapter);
        return rootView;
    }

    class TodaySaleViewPagerAdapter extends FragmentStatePagerAdapter{
        ArrayList<Fragment> items = new ArrayList<>();

        public TodaySaleViewPagerAdapter(@NonNull FragmentManager fm) {
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
        public int getCount() {
            return items.size();
        }
    }
}
