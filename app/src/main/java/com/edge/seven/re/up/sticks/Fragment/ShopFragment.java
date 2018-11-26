package com.edge.seven.re.up.sticks.Fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.edge.seven.re.up.sticks.Interfaces.DripFragment;
import com.edge.seven.re.up.sticks.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ShopFragment extends DripFragment {

    @BindView(R.id.shopframe) FrameLayout frameLayout;

    public ShopFragment() {
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_shop, container, false);

        ButterKnife.bind(this, v);
        setFrameLayout(frameLayout);

        return v;
    }

}
