package com.example.swproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText addId= (EditText) findViewById(R.id.addID);
        EditText addPw= (EditText) findViewById(R.id.addPW2);
        EditText checkPw = (EditText) findViewById(R.id.checkPW);
        Button registerBtn = (Button) findViewById(R.id.registerBtn);
        ImageButton backBtn = (ImageButton)findViewById(R.id.backBtn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userID = addId.getText().toString().trim();
                String userPW = addPw.getText().toString().trim();
                String checkPW = checkPw.getText().toString();
                if (userID.isEmpty()||userPW.isEmpty()){
                    Toast.makeText(getApplicationContext(), "아이디와 패스워드를 입력해주세요",Toast.LENGTH_LONG).show();
                }else if (!userPW.equals(checkPW)){
                    Toast.makeText(getApplicationContext(), "비밀번호가 서로 다릅니다", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(), "회원가입에 성공했습니다. 로그인 페이지로 이동합니다.", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent2);
            }
        });

    }
}