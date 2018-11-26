package com.edge.seven.re.up.sticks.Activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.edge.seven.re.up.sticks.Adapter.RegistrationAdapter;
import com.edge.seven.re.up.sticks.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegistrationActivity extends AppCompatActivity {

    @BindView(R.id.reg_pager)
    ViewPager pager;

    RegistrationAdapter registrationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ButterKnife.bind(this);

        registrationAdapter = new RegistrationAdapter(getSupportFragmentManager());
        pager.setAdapter(registrationAdapter);
    }
}
