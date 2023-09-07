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

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.swproject.ChooseChallenge;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FragmentChangeListener{
    private FragmentManager fragmentManager = getSupportFragmentManager();
    // Fragment 클래스와 참조변수들
    Home home;
    Ranking ranking;
    Market market;
    Community community;
    MyPage mypage;
    MainChallenges mainChallenges = new MainChallenges();

    // 이전에 선택된 버튼을 저장할 변수
    private Button previousButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton settingBtn = (ImageButton)findViewById(R.id.settingBtn);
        settingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "설정 버튼이 눌림", Toast.LENGTH_SHORT).show();
            }
        });
        // Fragment 모음
        home = new Home();
        ranking = new Ranking();
        market = new Market();
        community = new Community();
        mypage = new MyPage();


        //재민아 여기야,,,여기가 LoginActivity에서 userName 받고 다시 mypage 프래그먼트로 전달하는 곳이야
        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        //프래그먼트에 정보전달
        Bundle bundle = new Bundle();
        bundle.putString("userName",userName);
        mypage.setArguments(bundle);
        Bundle bundle_ranking = new Bundle();
        bundle_ranking.putString("userName",userName);
        ranking.setArguments(bundle_ranking);
        Log.d("LoginActivity", "userName: " + userName);
        //여기까지야,,


        fragmentManager.beginTransaction().replace(R.id.fragment_linear,home).commit();
        // 하단 바 버튼들
        Button home_button = (Button) findViewById(R.id.home_button);
        Button ranking_button = (Button) findViewById(R.id.ranking_button);
        Button market_button = (Button) findViewById(R.id.market_button);
        Button community_button = (Button) findViewById(R.id.community_button);
        Button mypage_button = (Button) findViewById(R.id.mypage_button);

        // 초기 버튼 선택 상태를 설정
        previousButton = home_button;
        previousButton.setTextColor(Color.parseColor("#0000FF"));

        // 각 버튼 onClick 메소드 설정
        View.OnClickListener buttonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int viewId = view.getId();

                // 이전에 선택된 버튼의 텍스트 색상을 검정색으로 변경
                previousButton.setTextColor(Color.BLACK);

                if (viewId == R.id.home_button) {
                    fragmentManager.beginTransaction().replace(R.id.fragment_linear,home).commit();
                    home_button.setTextColor(Color.parseColor("#0000FF"));
                    previousButton = home_button;
                } else if (viewId == R.id.ranking_button) {
                    fragmentManager.beginTransaction().replace(R.id.fragment_linear,ranking).commit();
                    ranking_button.setTextColor(Color.parseColor("#0000FF"));
                    previousButton = ranking_button;
                } else if (viewId == R.id.market_button) {
                    fragmentManager.beginTransaction().replace(R.id.fragment_linear,market).commit();
                    market_button.setTextColor(Color.parseColor("#0000FF"));
                    previousButton = market_button;
                } else if (viewId == R.id.community_button) {
                    fragmentManager.beginTransaction().replace(R.id.fragment_linear,community).commit();
                    community_button.setTextColor(Color.parseColor("#0000FF"));
                    previousButton = community_button;
                } else if (viewId == R.id.mypage_button) {
                    fragmentManager.beginTransaction().replace(R.id.fragment_linear,mypage).commit();
                    mypage_button.setTextColor(Color.parseColor("#0000FF"));
                    previousButton = mypage_button;
                }
            }
        };

        // 각 버튼의 setOnClickListener 설정
        home_button.setOnClickListener(buttonClickListener);
        ranking_button.setOnClickListener(buttonClickListener);
        market_button.setOnClickListener(buttonClickListener);
        community_button.setOnClickListener(buttonClickListener);
        mypage_button.setOnClickListener(buttonClickListener);

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