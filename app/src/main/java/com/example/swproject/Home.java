package com.example.swproject;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentResultListener;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class Home extends Fragment {
    ViewPager2 viewPager2;
    ChallengePagerAdapter adapter;
    TextView cp; // challenge_position 줄임말
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // fragment는 자체 activity가 없기 때문에 (onCreate에 있는) setContentView를 못쓰고, 대신 onCreateView를 사용해야 한다.
        // viewpager.findViewById()
        View view = inflater.inflate(R.layout.home,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager2 = view.findViewById(R.id.pager);
        adapter = new ChallengePagerAdapter(this);

        // 클래스를 사용하려면 참조변수를 통해 클래스를 가리키고 그 참조변수를 사용해야 한다
        ChallengeFragment1 cf1 = new ChallengeFragment1();
        adapter.addItem(cf1);
        ChallengeFragment2 cf2 = new ChallengeFragment2();
        adapter.addItem(cf2);

        viewPager2.setAdapter(adapter);

        // viewPager2의 현재 프래그먼트 위치를 받아와서 TextView에 적용
        cp = view.findViewById(R.id.challenge_position);
        cp.setText(String.valueOf(viewPager2.getCurrentItem()+1));

        // viewPager2의 페이지 변경 리스너를 설정
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                cp.setText(String.valueOf(position+1)); // 페이지 변경 시 TextView 업데이트
            }
        });
    }



    class ChallengePagerAdapter extends FragmentStateAdapter {
        ArrayList<Fragment> items = new ArrayList<>();
        public ChallengePagerAdapter(Fragment fragment) {
            super(fragment);
        }

        // ArrayList에 fragment 추가
        public void addItem(Fragment item){
            items.add(item);
        }

        @NonNull
        @Override
        // viewPager2에 fragment를 제공
        // position은 fragment가 ArrayList에 추가될 때 자동으로 할당
        // viewPager2가 createFragment 메소드를 자동으로 호출하여 사용
        public Fragment createFragment(int position) {
            // ArrayList의 position 위치의 fragment를 return
            return items.get(position);
        }

        @Override
        public int getItemCount() {
            return items.size();
        }
    }
}


