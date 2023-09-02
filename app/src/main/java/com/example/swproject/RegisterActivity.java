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

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    private Button registerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // 아이디 값 찾아주기
        EditText addID = (EditText)findViewById(R.id.loginID);
        EditText addPW2 = (EditText)findViewById(R.id.addPW2);
        EditText addName = (EditText)findViewById(R.id.addName);
        EditText checkPw = findViewById(R.id.loginPW);
        registerBtn = findViewById(R.id.registerBtn);
        ImageButton backBtn = (ImageButton)findViewById(R.id.backBtn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userID = addID.getText().toString().trim();
                String userPW2 = addPW2.getText().toString().trim();
                String checkPW = checkPw.getText().toString();
                String userName = addName.getText().toString().trim();

                if (userID.isEmpty()||userPW2.isEmpty()||userName.isEmpty()){
                    Toast.makeText(getApplicationContext(), "회원정보를 제대로 입력해 주세요",Toast.LENGTH_LONG).show();
                }else if (!userPW2.equals(checkPW)){
                    Toast.makeText(getApplicationContext(), "비밀번호가 서로 다릅니다", Toast.LENGTH_LONG).show();
                }else{


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
                                e.printStackTrace();
                            }

                        }
                    };

                    RegisterRequest registerRequest = new RegisterRequest(userID,userName,userPW2,responseListener);
                    RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
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
