package com.test.linkedin.io;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chris on 1/19/17.
 */

public class LinkedInAPI {

    private static Retrofit RETROFIT;

    public static Retrofit getInstance(){
        //The adapter will be a singleton
        if(RETROFIT == null)
            RETROFIT = new Retrofit.Builder()
                    .baseUrl(LinkedAPIConstants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        return RETROFIT;
    }
}
