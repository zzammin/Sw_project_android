package com.example.swproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class Home extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // fragment는 자체 activity가 없기 때문에 (onCreate에 있는) setContentView를 못쓰고, 대신 onCreateView를 사용해야 한다.
        // viewpager.findViewById()

        return inflater.inflate(R.layout.home,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewPager2 viewPager2 = view.findViewById(R.id.pager);
        ChallengePagerAdapter adapter = new ChallengePagerAdapter(this);
        viewPager2.setAdapter(adapter);
    }

    class ChallengePagerAdapter extends FragmentStateAdapter {
        ArrayList<Fragment> items = new ArrayList<Fragment>();

        public ChallengePagerAdapter(Fragment fragment) {
            super(fragment);
        }

        public void addItem(Fragment item){
            items.add(item);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return new ChallengeFragment1();
        }

        @Override
        public int getItemCount() {
            return 5;
        }
    }
}


