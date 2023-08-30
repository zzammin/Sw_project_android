package com.example.swproject;

import static android.app.ProgressDialog.show;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Register extends AppCompatActivity {

    private Button registerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // 아이디 찾기
        EditText addID = (EditText)findViewById(R.id.addID);
        EditText addPW = (EditText)findViewById(R.id.addPW2);
        EditText addAge = (EditText)findViewById(R.id.addAge);
        EditText addName = (EditText)findViewById(R.id.addName);
        registerBtn = findViewById(R.id.registerBtn);
        EditText checkPw = findViewById(R.id.checkPW);
        ImageButton backBtn = (ImageButton)findViewById(R.id.backBtn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userID = addID.getText().toString().trim();
                String userPW = addPW.getText().toString().trim();
                String checkPW = checkPw.getText().toString();
                String userName = addName.getText().toString();
                int userAge = Integer.parseInt(addAge.getText().toString());

                if (userID.isEmpty()||userPW.isEmpty()){
                    Toast.makeText(getApplicationContext(), "아이디와 패스워드를 입력해주세요",Toast.LENGTH_LONG).show();
                }else if (!userPW.equals(checkPW)){
                    Toast.makeText(getApplicationContext(), "비밀번호가 서로 다릅니다", Toast.LENGTH_LONG).show();
                }else {


                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                boolean success = jsonObject.getBoolean("success");
                                if(success){ // 회원 가입 성공
                                    Toast.makeText(getApplicationContext(), "회원가입에 성공했습니다. 로그인 페이지로 이동합니다.", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                                    startActivity(intent);

                                }
                                else{ // 회원 가입 실패
                                    Toast.makeText(getApplicationContext(), "회원가입에 실패했습니다. 회원가입 페이지로 이동합니다.", Toast.LENGTH_LONG).show();
                                    return;
                                }
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    };

                    RegisterRequest registerRequest = new RegisterRequest(userID,userName,userPW,userAge,responseListener);
                    RequestQueue queue = Volley.newRequestQueue(Register.this);
                    queue.add(registerRequest);
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