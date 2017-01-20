package com.test.linkedin.io.services;


import com.test.linkedin.io.LinkedAPIConstants;
import com.test.linkedin.model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface LoginService {

    @FormUrlEncoded
    @POST(LinkedAPIConstants.LOGIN_PATH)
    Call<User> login(@Field("user") String user, @Field("password") String password);

}

