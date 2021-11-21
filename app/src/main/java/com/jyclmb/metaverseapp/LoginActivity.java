package com.jyclmb.metaverseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.jyclmb.metaverseapp.api.RequestPlaceholder;
import com.jyclmb.metaverseapp.api.RetrofitBuilder;
import com.jyclmb.metaverseapp.pojos.Login;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {

    private EditText username,password;
    private Button button_login;
    public RetrofitBuilder retrofitBuilder;
    public RequestPlaceholder requestPlaceholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        button_login = (Button) findViewById(R.id.button_login);

        retrofitBuilder = new RetrofitBuilder();
        requestPlaceholder = retrofitBuilder.getRetrofit().create(RequestPlaceholder.class);

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText() != null && password.getText() != null) {
                    Call<Login> LoginCall = requestPlaceholder.login(new Login(null, username.getText().toString(), null, null, password.getText().toString()));

                    LoginCall.enqueue(new Callback<Login>() {
                        @Override
                        public void onResponse(Call<Login> call, Response<Login> response) {
                            if (!response.isSuccessful()) {
                                if (response.code() == 404) {
                                    Toast.makeText(LoginActivity.this, "User not found!", Toast.LENGTH_SHORT).show();
                                    Log.e("LOGIN_ERR 1", response.message());
                                    Log.e("response code : " , String.valueOf(response.code()));
                                } else {
                                    Toast.makeText(LoginActivity.this, "There was an error upon logging in the API", Toast.LENGTH_SHORT).show();
                                    Log.e("LOGIN_ERR 2", response.message());
                                }
                            }else{
                                if (response.code() == 200) {
                                    Login loginResponse = response.body();
                                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                    intent.putExtra("USERID", loginResponse.getId());
                                    intent.putExtra("USERNAME", loginResponse.getUsername());
                                    intent.putExtra("TOKEN", loginResponse.getToken());

                                    startActivity(intent);
                                    finish();
//                                    Toast.makeText(getApplicationContext(), "Login API successful", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<Login> call, Throwable t) {
                            Toast.makeText(LoginActivity.this, "There was an error upon logging in the API", Toast.LENGTH_SHORT).show();
                            Log.e("LOGIN_ERR 2", t.getMessage());
                        }
                    });
                } else {
                    Toast.makeText(LoginActivity.this, "Please supply all the fields to login!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}