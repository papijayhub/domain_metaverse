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

import com.google.android.material.button.MaterialButton;
import com.jyclmb.metaverseapp.api.RequestPlaceholder;
import com.jyclmb.metaverseapp.api.RetrofitBuilder;
import com.jyclmb.metaverseapp.pojos.Login;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {
//    EditText mTextUsername;
//    EditText mTextPassword;
//    Button mButtonLogin;
//    TextView mTextViewRegister;
//
//    public RetrofitBuilder retrofitBuilder;
//    public RequestPlaceholder requestPlaceholder;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        mTextUsername = (EditText) findViewById(R.id.edittext_username);
//        mTextPassword = (EditText) findViewById(R.id.edittext_password);
//        mButtonLogin = (Button) findViewById(R.id.button_login);
//        mTextViewRegister = (TextView) findViewById(R.id.textview_register);
//
//        retrofitBuilder new RetrofitBuilder();
//        requestPlaceholder = retrofitBuilder.getRetrofit()create(RequestPlaceholder.class);
//
//        mTextViewRegister.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent registerIntent = new Intent(LoginActivity.this, com.jyclmb.metaverseapp.RegisteredActivity.class);
//                startActivity(registerIntent);
//            }
//        });

    public EditText username, password;
    public Button button_login;

    public RetrofitBuilder retrofitBuilder;
    public Retrofit requestPlaceholder;

    @Override
            protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        button_login = findViewById(R.id.button_login);

        retrofitBuilder = new RetrofitBuilder();
        requestPlaceholder = retrofitBuilder.getRetrofit().create(RequestPlaceholder.class);

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText() != null && password.getText() != null){
                    Call<login> loginCall = requestPlaceholder.Login(new Login(null, username=getText().toString(), null, null, password=getText().toString()));

                    loginCall.enqueue(new Callback<login>() {
                        @Override
                        public void onResponse(Call<login> call, Response<login> response) {
                            if (!response.isSuccessful()) {
                                if (response.code() == 404) {
                                    Toast.makeText(LoginActivity.this, "User not found", Toast.LENGTH_SHORT).show();
                                    Log.e("LOGING_ERR", response.message());
                                } else {
                                    Toast.makeText(LoginActivity.this, "There was an error upon logginH in the API", Toast.LENGTH_SHORT).show();
                                    Log.e("LOGING_ERR", response.message());
                                }

                            } else {
                                if (response.code() == 200) {
                                    login loginResponse = response.body();
                                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                    intent.putExtra("USERID", loginResponse.getId());
                                    intent.putExtra("USERNAME", loginResponse.getUsername());
                                    intent.putExtra("TOKEN", loginResponse.getToken());
                                    
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<login> call, Throwable t) {
                            Toast.makeText(LoginActivity.this, "There was an error upon logginH in the API", Toast.LENGTH_SHORT).show();
                            Log.e("LOGING_ERR", t.getMessage());
                        }
                    });
                } else {
                    Toast.makeText(LoginActivity.this, "Please Supply All the Fields to Login!", Toast.LENGTH_SHORT).show();
                }


            }
        });














    }
}