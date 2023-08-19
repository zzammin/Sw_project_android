package com.example.swproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

public class ChallengeFragment1 extends Fragment {
//    ViewPager2 viewPager2;
//    Home homeFragment;
//    Home.ChallengePagerAdapter adapter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.challenge_fragment1, container,false);
        return rootView;
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//
//         클래스 안에 클래스 => inner Class라 해서 메소드나 멤버변수를 사용할 때와 같이 .을 쓴다
//         내부 클래스를 다른 곳에서 쓸 경우 그 내부 클래스를 감싸고 있는 클래스의 인스턴스를 먼저 생성해야 함
//         homeFragment = new Home();
//         adapter = homeFragment.new ChallengePagerAdapter(this);
//
//        Button next = (Button) view.findViewById(R.id.next);
//        next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getContext(),"버튼을 눌렸습니다",Toast.LENGTH_LONG).show();
//            }
//        });
//    }
}
