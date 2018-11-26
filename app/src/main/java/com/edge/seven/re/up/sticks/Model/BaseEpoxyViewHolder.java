package com.edge.seven.re.up.sticks.Model;

import android.support.annotation.CallSuper;
import android.view.View;

import com.airbnb.epoxy.EpoxyHolder;

import butterknife.ButterKnife;

public class BaseEpoxyViewHolder extends EpoxyHolder {
    @CallSuper

    @Override
    protected void bindView(View itemView) {
        ButterKnife.bind(this, itemView);
    }
}
