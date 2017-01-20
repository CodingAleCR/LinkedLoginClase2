package com.test.linkedin.presenters;

import com.test.linkedin.common.BasePresenter;
import com.test.linkedin.interactors.UserLoginInteractor;
import com.test.linkedin.io.callbacks.LoginCallback;
import com.test.linkedin.model.User;
import com.test.linkedin.views.LoginView;

/**
 * Created by chris on 1/19/17.
 */

public class LoginPresenter extends BasePresenter implements LoginCallback{


    private LoginView view;

    private UserLoginInteractor interactor;

    public LoginPresenter(LoginView view) {

        this.view = view;
        interactor = new UserLoginInteractor();

    }

    /**
     * Login the user in the API
     * @param user
     * @param password
     */
    public void loginUser(String user, String password){

        if(interactor != null) {
            interactor.login(user, password, this);
        }
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public void onLoginSuccess(User user) {

        this.view.displayLoginSuccess(user);

    }

    @Override
    public void onLoginFailure(String error) {
        this.view.displayError();
    }
}
