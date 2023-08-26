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
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class Market extends Fragment {
    ViewPager2 marketSalePager;
    TodaySaleViewPagerAdapter adapter;
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
        // !!!!!!!!!!! 다른 프래그먼트 갔다가 market 프래그먼트 오면 뷰페이저들이 없어지는 문제 !!!!!!!!!!!!!!!

        //오늘의 할인 부분 뷰페이저
        marketSalePager = (ViewPager2)view.findViewById(R.id.Today_Sale_pager);
        marketSalePager.setOffscreenPageLimit(3);
        adapter = new TodaySaleViewPagerAdapter(this);

        Market_Sale_Fragment1 fragment1 = new Market_Sale_Fragment1();
        adapter.addItem(fragment1);

        Market_Sale_Fragment2 fragment2 = new Market_Sale_Fragment2();
        adapter.addItem(fragment2);

        Market_Sale_Fragment3 fragment3 = new Market_Sale_Fragment3();
        adapter.addItem(fragment3);

        marketSalePager.setAdapter(adapter);

        //인기 상품 부분 뷰페이저
        ViewPager MarketBestItemPager = (ViewPager)view.findViewById(R.id.Market_BestItem_pager);
        MarketBestItemPager.setOffscreenPageLimit(2);
        BestItemViewPagerAdapter adapter2 = new BestItemViewPagerAdapter(requireActivity().getSupportFragmentManager());

        Market_BestItem_Fragment1 B_I_fragment1 = new Market_BestItem_Fragment1();
        adapter2.addItem(B_I_fragment1);

        Market_BestItem_Fragment2 B_I_fragment2 = new Market_BestItem_Fragment2();
        adapter2.addItem(B_I_fragment2);

        MarketBestItemPager.setAdapter(adapter2);
    }

    // 여기까지가 문제

    class TodaySaleViewPagerAdapter extends FragmentStateAdapter {
        ArrayList<Fragment> items = new ArrayList<>();

        public TodaySaleViewPagerAdapter(@NonNull Fragment fragment) {
            super(fragment.requireActivity());
        }

        public void addItem(Fragment item){
            items.add(item);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position){
            return items.get(position);
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

    }

    class BestItemViewPagerAdapter extends FragmentStatePagerAdapter{
        ArrayList<Fragment> items = new ArrayList<>();

        public BestItemViewPagerAdapter(@NonNull FragmentManager fm) {
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
