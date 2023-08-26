package com.example.swproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText addId= (EditText) findViewById(R.id.addID);
        EditText addPw= (EditText) findViewById(R.id.checkPW);
        Button loginButton = (Button)findViewById(R.id.loginBtn);
        Button RegisterButton = (Button)findViewById(R.id.registerBtn_inLogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userID = addId.getText().toString().trim();
                String userPW = addPw.getText().toString().trim();
                if (userID.isEmpty()||userPW.isEmpty()){
                    Toast.makeText(getApplicationContext(), "아이디와 패스워드를 입력해주세요",Toast.LENGTH_LONG).show();
                }else {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(),Register.class);
                startActivity(intent2);
            }
        });
    }
}