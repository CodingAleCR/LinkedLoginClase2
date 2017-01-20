package com.test.linkedin.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.test.linkedin.R;
import com.test.linkedin.common.BaseActivity;
import com.test.linkedin.common.BasePresenter;
import com.test.linkedin.model.User;
import com.test.linkedin.presenters.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by chris on 1/20/17.
 */

public class ProfileActivitity extends BaseActivity{

    public User user;

    @BindView(R.id.profileImage)
    ImageView profileImage;

    @BindView(R.id.nameText)
    TextView name;
    @BindView(R.id.professionText)
    TextView profession;
    @BindView(R.id.companyText)
    TextView company;

    @BindView(R.id.textViewSkills)
    TextView skills;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButterKnife.bind(this);

        Intent intent =  getIntent();

        user = intent.getParcelableExtra("user");

        setupUI();

    }


    public void setupUI() {


        if(user != null) {

            name.setText(user.getFirstName() + " " + user.getLastName());

            profession.setText(user.getProfession());

            company.setText(user.getCountry());

            skills.setText(user.getSkills());

            Glide.with(this).load(user.getImageURL()).into(profileImage);

        }
    }




    @Override
    protected int getLayout() {
        return R.layout.activity_linked_in_profile_detail;
    }

    @Nullable
    @Override
    protected BasePresenter getPresenter() {
        return null;
    }
}
