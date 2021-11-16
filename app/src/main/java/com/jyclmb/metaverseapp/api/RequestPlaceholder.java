package com.jyclmb.metaverseapp.api;

import com.jyclmb.metaverseapp.pojos.Login;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
public interface RequestPlaceholder {
    @POST('login')
    Call<Login> login(@Body Login login);
}
