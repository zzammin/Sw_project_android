package com.example.swproject;

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

public class MainActivity extends AppCompatActivity {
    Home home;
    Ranking ranking;
    Market market;
    Community community;
    MyPage mypage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // fragment 모음
        home = new Home();
        ranking = new Ranking();
        market = new Market();
        community = new Community();
        mypage = new MyPage();

        getSupportFragmentManager().beginTransaction().replace(R.id.fregment_linear,home).commit();

        // id가 pager인 viewpager가 home.xml에 있기 때문에 inflate
//        LayoutInflater inflater = LayoutInflater.from(this);
//        View inflate_home=inflater.inflate(R.layout.home,null);
        //

        // 얘를 Home에 옮겨야 될 듯?? 어떻게 옮기지?
//        ViewPager2 pager = inflate_home.findViewById(R.id.pager);
//
//        pager.setOffscreenPageLimit(5);
//
//        pager.setAdapter(new ChallengePagerAdapter(this));

        NavigationBarView navigationBarView = findViewById(R.id.bottom_tab);
        navigationBarView.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.ranking) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fregment_linear, ranking).commit();
                } else if (itemId == R.id.market) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fregment_linear, market).commit();
                } else if (itemId == R.id.community) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fregment_linear, community).commit();
                } else if (itemId == R.id.mypage) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fregment_linear, mypage).commit();
                }
            }
        });

        TextView cake_it = (TextView) findViewById(R.id.Cake_it);
        cake_it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fregment_linear,home).commit();
            }
        });
    }
}