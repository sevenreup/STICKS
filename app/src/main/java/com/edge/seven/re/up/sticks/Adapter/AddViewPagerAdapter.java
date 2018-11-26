package com.edge.seven.re.up.sticks.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edge.seven.re.up.sticks.Fragment.AddFrag.AddModel;

import butterknife.ButterKnife;

public class AddViewPagerAdapter extends PagerAdapter {
    private Context context;


    public AddViewPagerAdapter(Context context)
    {
        this.context = context;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        AddModel model = AddModel.values()[position];
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewGroup layout = (ViewGroup) inflater.inflate(model.getLayout(), container, false);
        container.addView(layout);
        ButterKnife.bind(this, layout);
        return layout;
    }

    @Override
    public int getCount() {
        return AddModel.values().length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }
}
