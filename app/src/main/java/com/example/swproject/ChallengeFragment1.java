package com.example.swproject;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

public class ChallengeFragment1 extends Fragment {
    ViewPager2 viewPager2;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.challenge_fragment1, container,false);

        // fragment에서 다른 xml에 있는 뷰를 사용하려면 당연히 inflation 과정이 필요
        View homeView = LayoutInflater.from(requireContext()).inflate(R.layout.home,null);
        viewPager2 = homeView.findViewById(R.id.pager);

        Button next = (Button) rootView.findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle(); // bundle을 통해 프래그먼트 간에 값 전달
                int currentPosition = viewPager2.getCurrentItem();
                int nextPosition = (currentPosition + 1) % 5;

                bundle.putInt("nextPosition",nextPosition); // 넘기고 싶은 값을 bundle에 저장
                getParentFragmentManager().setFragmentResult("challengeResult", bundle);
                Log.d("ChallengeFragment1", "FragmentResult 보냄: nextPosition = " + bundle);
            }
        });

        return rootView;
    }

    // 버튼이 클릭되는건 Home.java에서 적용이 안되고 ChallengeFragment1에서 적용이 됨.
    // => 따라서 viewPager2에 들어가는 fragment의 next버튼 onClick 이벤트를 각 fragment에서 처리해야될 듯!!!!!!
    // 여기에 viewPager2 불러오고 여기의 next Button 해서 온클릭 이벤트 넣어보자


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        // fragment에서 다른 xml에 있는 뷰를 사용하려면 당연히 inflation 과정이 필요
//        View homeView = LayoutInflater.from(requireContext()).inflate(R.layout.home,null);
//        viewPager2 = homeView.findViewById(R.id.pager);
//
//        Button next = (Button) view.findViewById(R.id.next);
//        next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Bundle result = new Bundle(); // bundle을 통해 프래그먼트 간에 값 전달
//                int currentPosition = viewPager2.getCurrentItem();
//                int nextPosition = (currentPosition + 1) % 5;
//                result.putInt("nextPosition",nextPosition); // 넘기고 싶은 값을 bundle에 저장
//
//                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
//                ChallengeFragment2 challengeFragment2 = new ChallengeFragment2(); // ChallengeFragment2 선언
//                challengeFragment2.setArguments(result); // bundle을 ChallengeFragment2로 보낼 준비
//                transaction.replace(R.id.pager,challengeFragment2).commit();
//                Log.d("ChallengeFragment1", "FragmentResult 보냄: nextPosition = " + result);
//            }
//        });
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
    }
}
