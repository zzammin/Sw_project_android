package com.example.swproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.swproject.ChooseChallenge;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FragmentChangeListener{
    // fragment를 사용하려면 FragmentManager가 필요
    private FragmentManager fragmentManager = getSupportFragmentManager();
    // Fragment 클래스와 참조변수들
    Home home;
    Ranking ranking;
    Market market;
    Community community;
    MyPage mypage;
    ChooseChallenge challengeFragment1;
    ChallengeFragment2 challengeFragment2;
    MainChallenges mainChallenges = new MainChallenges();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Fragment 모음
        home = new Home();
        ranking = new Ranking();
        market = new Market();
        community = new Community();
        mypage = new MyPage();

        fragmentManager.beginTransaction().replace(R.id.fragment_linear,home).commit();

        // 하단 바
        NavigationBarView navigationBarView = findViewById(R.id.bottom_tab);
        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.ranking && fragmentManager.findFragmentById(R.id.fragment_linear) != ranking) {
                    fragmentManager.beginTransaction().replace(R.id.fragment_linear, ranking).commit();
                } else if (itemId == R.id.market && fragmentManager.findFragmentById(R.id.fragment_linear) != market) {
                    fragmentManager.beginTransaction().replace(R.id.fragment_linear, market).commit();
                } else if (itemId == R.id.community && fragmentManager.findFragmentById(R.id.fragment_linear) != community) {
                    fragmentManager.beginTransaction().replace(R.id.fragment_linear, community).commit();
                } else if (itemId == R.id.mypage && fragmentManager.findFragmentById(R.id.fragment_linear) != mypage) {
                    fragmentManager.beginTransaction().replace(R.id.fragment_linear, mypage).commit();
                }
                return true;
            }
        });


        // Cake It! 로고 click 시 home 으로 돌아오기
        ImageView home_button = (ImageView) findViewById(R.id.home_button);
        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction().replace(R.id.fragment_linear,home).commit();
            }
        });
    }

    @Override
    public void onFragmentChange() {
        // ChallengeFragment1에서 발생한 이벤트를 처리하는 메서드
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_linear, mainChallenges); // MainChallenges 프래그먼트로 변경
        transaction.addToBackStack(null); // 백스택에 추가하여 뒤로가기 버튼으로 이전 상태 복원 가능하도록
        transaction.commit();
    }
}