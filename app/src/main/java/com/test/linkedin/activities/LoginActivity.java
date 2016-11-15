package com.test.linkedin.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.test.linkedin.R;
import com.test.linkedin.utils.AlertUtils;

public class LoginActivity extends AppCompatActivity {

    private EditText _emailEditText;
    private EditText _passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupUI();
    }

    private void setupUI(){

        _emailEditText = (EditText)findViewById(R.id.emailEditText);
        _passwordEditText = (EditText)findViewById(R.id.passwordEditText);

    }

    public void onLoginClicked(View view){

        //Validar que todo este lleno
        if(isValid())
        {
            showDetailActivity();
        }
    }

    private void showDetailActivity(){

        Intent detailIntent =  new Intent(this, LinkedInProfileDetail.class);
        finish();
        startActivity(detailIntent);
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

}
