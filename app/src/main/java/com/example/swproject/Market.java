package com.example.swproject;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class Market extends Fragment {
    ViewPager2 marketSalePager;
    TodaySaleViewPagerAdapter adapter;
    ViewPager2 marketBestItemPager;
    BestItemViewPagerAdapter adapter2;
    ArrayList<Fragment> today_items = new ArrayList<>();
    ArrayList<Fragment> best_items = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.market,container,false);
        return rootView;
    }

    // 변경한 것)
    // 1.ViewPager -> ViewPager2
    // 2.1번에 따른 Adapter 변경
    // 3.onCreateView의 내용을 onViewCreated로 옮김

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //오늘의 할인 부분 뷰페이저
        marketSalePager = (ViewPager2)view.findViewById(R.id.Today_Sale_pager);
        marketSalePager.setOffscreenPageLimit(3);
        adapter = new TodaySaleViewPagerAdapter(this);

        if(today_items.size()==0) {
            Market_Sale_Fragment1 fragment1 = new Market_Sale_Fragment1();
            adapter.addItem(fragment1);

            Market_Sale_Fragment2 fragment2 = new Market_Sale_Fragment2();
            adapter.addItem(fragment2);

            Market_Sale_Fragment3 fragment3 = new Market_Sale_Fragment3();
            adapter.addItem(fragment3);
        }
        marketSalePager.setAdapter(adapter);

        //인기 상품 부분 뷰페이저
        marketBestItemPager = (ViewPager2) view.findViewById(R.id.Market_BestItem_pager);
        marketBestItemPager.setOffscreenPageLimit(2);
        adapter2 = new BestItemViewPagerAdapter(this);

        if(best_items.size()==0) {
            Market_BestItem_Fragment1 B_I_fragment1 = new Market_BestItem_Fragment1();
            adapter2.addItem(B_I_fragment1);

            Market_BestItem_Fragment2 B_I_fragment2 = new Market_BestItem_Fragment2();
            adapter2.addItem(B_I_fragment2);
        }

        marketBestItemPager.setAdapter(adapter2);
    }

    // 여기까지가 문제

    class TodaySaleViewPagerAdapter extends FragmentStateAdapter {


        public TodaySaleViewPagerAdapter(@NonNull Fragment fragment) {
            super(fragment.requireActivity());
        }

        public void addItem(Fragment item){
            today_items.add(item);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position){
            return today_items.get(position);
        }

        @Override
        public int getItemCount() {
            return today_items.size();
        }

    }

    class BestItemViewPagerAdapter extends FragmentStateAdapter{

        public BestItemViewPagerAdapter(@NonNull Fragment fragment) {
            super(fragment.requireActivity());
        }

        public void addItem(Fragment item){
            best_items.add(item);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position){
            return best_items.get(position);
        }

        @Override
        public int getItemCount() {
            return best_items.size();
        }
    }
}
