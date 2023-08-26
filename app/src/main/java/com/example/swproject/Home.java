package com.example.swproject;

import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentResultListener;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator3;

public class Home extends Fragment {
    ViewPager2 viewPager2;
    ChallengePagerAdapter adapter;
    ArrayList<Fragment> items = new ArrayList<>();
    private CircleIndicator3 mIndicator;
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

        // items에 item이 있을 경우 추가하는 것을 막는 제어문 필요
        // => viewPager2의 fragment, indicator의 무한 증식 방지
        if(items.size()==0) {
            ChooseChallenge choose = new ChooseChallenge();
            adapter.addItem(choose);
            ChallengeFragment1 cf1 = new ChallengeFragment1();
            adapter.addItem(cf1);
            ChallengeFragment2 cf2 = new ChallengeFragment2();
            adapter.addItem(cf2);
            ChallengeFragment3 cf3 = new ChallengeFragment3();
            adapter.addItem(cf3);
            ChallengeFragment4 cf4 = new ChallengeFragment4();
            adapter.addItem(cf4);
        }

        viewPager2.setAdapter(adapter);

        // Indicator 생성
        mIndicator = view.findViewById(R.id.indicators);
        mIndicator.setViewPager(viewPager2);
        mIndicator.createIndicators(items.size(),0);

    }

    class ChallengePagerAdapter extends FragmentStateAdapter {
        public ChallengePagerAdapter(Fragment fragment) {
            super(fragment.requireActivity());
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


