package com.jyclmb.metaverseapp.api;

import com.jyclmb.metaverseapp.pojos.Login;
/*import com.jyclmb.metaverseapp.pojos.Posts;*/

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RequestPlaceholder {

    @POST("login")
    Call<Login> login(@Body Login login);

//    @GET("get-all-posts")
////    Call<List<Posts>> getAllPost(@Query("t") String t,@Query("u") String u);
//    Call<List<Posts>> getAllPost();
}



