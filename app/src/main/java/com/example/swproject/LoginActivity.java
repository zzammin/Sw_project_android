package com.example.swproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText loginID= (EditText) findViewById(R.id.loginID);
        EditText loginPW= (EditText) findViewById(R.id.loginPW);
        Button loginButton = (Button)findViewById(R.id.loginBtn);
        Button RegisterButton = (Button)findViewById(R.id.registerBtn_inLogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userID = loginID.getText().toString().trim();
                String userPass = loginPW.getText().toString().trim();
                if (userID.isEmpty()||userPass.isEmpty()){
                    Toast.makeText(getApplicationContext(), "아이디와 패스워드를 입력해주세요",Toast.LENGTH_LONG).show();
                }else {
                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                boolean success = jsonObject.getBoolean("success");
                                if(success){ // 로그인 성공
                                    String userID = jsonObject.getString("userID");
                                    String userPW = jsonObject.getString("userPassword");
<<<<<<< Updated upstream
                                    Toast.makeText(getApplicationContext(), "로그인에 성공했습니다.", Toast.LENGTH_LONG).show();
=======
                                    String userName = jsonObject.getString("userName");

                                    Toast.makeText(getApplicationContext(), userName+"님 환영합니다!", Toast.LENGTH_LONG).show();



>>>>>>> Stashed changes
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    intent.putExtra("userID",userID);
                                    intent.putExtra("userPW",userPW);
                                    intent.putExtra("userName",userName);
                                    startActivity(intent);

<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
                                }
                                else{ // 로그인 실패
                                    Toast.makeText(getApplicationContext(), "로그인에 실패했습니다.", Toast.LENGTH_LONG).show();
                                    return;
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    LoginRequest loginRequest = new LoginRequest(userID,userPass,responseListener);
                    RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                    queue.add(loginRequest);
                }
            }
        });

        RegisterButton.setOnClickListener(new View.OnClickListener() { //회원 가입 버튼 클릭
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
}
