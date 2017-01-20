package com.test.linkedin.interactors;

import com.test.linkedin.io.LinkedInAPI;
import com.test.linkedin.io.callbacks.LoginCallback;
import com.test.linkedin.io.services.LoginService;
import com.test.linkedin.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by chris on 1/19/17.
 */

public class UserLoginInteractor {


    private LoginService loginService;

    public UserLoginInteractor(){

        loginService = LinkedInAPI.getInstance().create(LoginService.class);
    }

    public void login(String user, String password, final LoginCallback callback) {

        Call<User> call = loginService.login(user, password);

        call.enqueue(new Callback<User>() {

            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if( response.isSuccessful()) {
                    callback.onLoginSuccess(response.body());
                } else {
                    callback.onLoginFailure("Incorrect email or password");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

                callback.onLoginFailure("Incorrect email or password");
            }

        });

    }

}
