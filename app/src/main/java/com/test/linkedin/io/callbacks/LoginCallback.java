package com.test.linkedin.io.callbacks;

import com.test.linkedin.model.User;

/**
 * Created by chris on 1/19/17.
 */

public interface LoginCallback {

    void onLoginSuccess(User user);

    void onLoginFailure(String error);

}
