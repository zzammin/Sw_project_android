package com.example.swproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
    private EditText addID, addPW;
    private Button registerBtn_inLogin,loginBtn;
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
                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                boolean success = jsonObject.getBoolean("success");
                                if(success){ // 회원 가입 성공
                                    String userId = jsonObject.getString("userId");
                                    String userPass = jsonObject.getString("userPassword");
                                    Toast.makeText(getApplicationContext(), "로그인에 성공했습니다.", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    intent.putExtra("userId",userId);
                                    intent.putExtra("userPass",userPass);
                                    startActivity(intent);

                                }
                                else{ // 회원 가입 실패
                                    Toast.makeText(getApplicationContext(), "로그인에 실패했습니다.", Toast.LENGTH_LONG).show();
                                    return;
                                }
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    };
                    LoginRequest loginRequest = new LoginRequest(userID,userPW,responseListener);
                    RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                    queue.add(loginRequest);
                }
            }
        });

        RegisterButton.setOnClickListener(new View.OnClickListener() { //회원 가입 버튼 클릭
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Register.class);
                startActivity(intent);
            }
        });

    }
}