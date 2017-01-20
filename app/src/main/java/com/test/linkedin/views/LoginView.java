package com.test.linkedin.views;

import com.test.linkedin.model.User;

/**
 * Created by chris on 1/19/17.
 */

public interface LoginView {

    void displayError();

    void displayLoginSuccess(User user);
}
