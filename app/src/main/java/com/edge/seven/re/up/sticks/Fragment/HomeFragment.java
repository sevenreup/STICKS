package com.edge.seven.re.up.sticks.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.edge.seven.re.up.sticks.Activity.DirectMessage;
import com.edge.seven.re.up.sticks.Activity.RegistrationActivity;
import com.edge.seven.re.up.sticks.Interfaces.DripFragment;
import com.edge.seven.re.up.sticks.R;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class HomeFragment extends DripFragment {

    FrameLayout frameLayout;

    public HomeFragment() {
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        ButterKnife.bind(this, v);
        setFrameLayout(frameLayout);
        frameLayout = v.findViewById(R.id.homeframe);
        return v;
    }

    @OnClick(R.id.sample_button)
    public void click()
    {
        startActivity(new Intent(getActivity(), RegistrationActivity.class));
    }
}
