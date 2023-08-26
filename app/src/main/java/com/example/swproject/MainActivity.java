package com.example.swproject;
package org.techtown.database;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.swproject.ChallengeFragment1;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

<<<<<<< Updated upstream
public class MainActivity extends AppCompatActivity {
=======

public class MainActivity extends AppCompatActivity implements FragmentChangeListener{
>>>>>>> Stashed changes
    // fragment를 사용하려면 FragmentManager가 필요
    private FragmentManager fragmentManager = getSupportFragmentManager();
    // Fragment 클래스와 참조변수들
    Home home;
    Ranking ranking;
    Market market;
    Community community;
    MyPage mypage;

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

        // fragment_linear (fragment가 들어갈 layout)에 fragment 추가
        fragmentManager.beginTransaction().add(R.id.fragment_linear,home).commit();
        fragmentManager.beginTransaction().add(R.id.fragment_linear,ranking).hide(ranking).commit();
        fragmentManager.beginTransaction().add(R.id.fragment_linear,market).hide(market).commit();
        fragmentManager.beginTransaction().add(R.id.fragment_linear,community).hide(community).commit();
        fragmentManager.beginTransaction().add(R.id.fragment_linear,mypage).hide(mypage).commit();

        // 하단 바
        NavigationBarView navigationBarView = findViewById(R.id.bottom_tab);
        navigationBarView.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                // 하단 바에서 선택하는 icon에 따라 show, hide 되는 fragment 변경
                if (itemId == R.id.ranking) {
                    fragmentManager.beginTransaction().show(ranking).hide(home).hide(market).hide(community).hide(mypage).commit();
                } else if (itemId == R.id.market) {
                    fragmentManager.beginTransaction().show(market).hide(home).hide(ranking).hide(community).hide(mypage).commit();
                } else if (itemId == R.id.community) {
                    fragmentManager.beginTransaction().show(community).hide(home).hide(ranking).hide(market).hide(mypage).commit();
                } else if (itemId == R.id.mypage) {
                    fragmentManager.beginTransaction().show(mypage).hide(home).hide(ranking).hide(market).hide(community).commit();
                }
            }
        });

        // Cake It! 로고 click 시 home 으로 돌아오기
        TextView cake_it = (TextView) findViewById(R.id.Cake_it);
        cake_it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fragmentManager.beginTransaction().show(home).hide(ranking).hide(market).hide(community).hide(mypage).commit();
            }
        });

    }
}