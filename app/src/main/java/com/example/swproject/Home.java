package com.example.swproject;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class Home extends Fragment {
    ViewPager2 viewPager2;
    ChallengePagerAdapter adapter;
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

        viewPager2 = view.findViewById(R.id.pager);
        adapter = new ChallengePagerAdapter(this);

        // 클래스를 사용하려면 참조변수를 통해 클래스를 가리키고 그 참조변수를 사용해야 한다
        ChallengeFragment1 cf1 = new ChallengeFragment1();
        adapter.addItem(cf1);
        ChallengeFragment2 cf2 = new ChallengeFragment2();
        adapter.addItem(cf2);

        viewPager2.setAdapter(adapter);

        // fragment에서 다른 xml에 있는 뷰를 사용하려면 당연히 inflation 과정이 필요
        View current = LayoutInflater.from(requireContext()).inflate(R.layout.challenge_fragment1,null);
        Button next = current.findViewById(R.id.next);
        // challenge_fragment1 에서의 next imageView에 클릭 이벤트
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 여기서 position을 늘리다가 5 이상 되면 다시 0으로 돌려야될 듯
                // Log.d("Button","next 버튼 클릭됨");
                int currentPosition = viewPager2.getCurrentItem(); // viewPager의 현재 아이템의 위치를 알고 싶으면 getCurrentItem() 메소드
                int itemCount = adapter.getItemCount();
                // Log.d("position","현재 위치 : "+currentPosition);
                // Log.d("position","아이템 개수 : "+itemCount);
                if(itemCount>0) {
                    int nextPosition = (currentPosition + 1) % itemCount;
                    viewPager2.setCurrentItem(nextPosition,true);
                }
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


