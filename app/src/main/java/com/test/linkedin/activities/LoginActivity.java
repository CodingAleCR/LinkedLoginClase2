package com.test.linkedin.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

import com.test.linkedin.R;
import com.test.linkedin.common.BaseActivity;
import com.test.linkedin.common.BasePresenter;
import com.test.linkedin.model.User;
import com.test.linkedin.presenters.LoginPresenter;
import com.test.linkedin.utils.AlertUtils;
import com.test.linkedin.views.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginView{

    @BindView(R.id.emailEditText)
    EditText _emailEditText;
    @BindView(R.id.passwordEditText)
    EditText _passwordEditText;

    LoginPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButterKnife.bind(this);

        presenter = new LoginPresenter(this);



    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Nullable
    @Override
    protected BasePresenter getPresenter() {
        return presenter;
    }

    @OnClick(R.id.loginButton)
    public void onLoginClicked(View view){

        //Validar que todo este lleno
        if(isValid())
        {
            presenter.loginUser(_emailEditText.getText().toString(), _passwordEditText.getText().toString());
        }
    }

    /**
     * This returns if the form is valid.
     * @return true if is valid
     */
    private boolean isValid(){
        boolean returnValue = true;

        if(_emailEditText.getText().toString().isEmpty()) {
            AlertUtils.showToaster(this, getString(R.string.insert_email_error_message));
            returnValue = false;
        }

        else if(_passwordEditText.getText().toString().isEmpty()) {

            AlertUtils.showToaster(this, getString(R.string.insert_password_error_message));
            returnValue = false;
        }

        return returnValue;
    }

    @Override
    public void displayError() {

        AlertUtils.showToaster(this, "Incorrect email or password");

    }

    @Override
    public void displayLoginSuccess(User user) {

        Intent detailIntent =  new Intent(this, ProfileActivitity.class);

        detailIntent.putExtra("user",user);

        finish();
        startActivity(detailIntent);

    }
}
