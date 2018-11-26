package com.edge.seven.re.up.sticks.Fragment.AddFrag;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edge.seven.re.up.sticks.Adapter.AddViewPagerAdapter;
import com.edge.seven.re.up.sticks.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddDMFragment extends Fragment {

    @BindView(R.id.add_pager)
    ViewPager viewPager;

    public AddDMFragment() {
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_dm, container, false);

        ButterKnife.bind(this, v);
        viewPager.setAdapter(new AddViewPagerAdapter(getContext()));

        return v;
    }

}
