package com.edge.seven.re.up.sticks.Model;

import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

public class NavFrag {

    private Fragment fragment;
    private AHBottomNavigationItem item;

    public NavFrag(@StringRes int title, @DrawableRes int resource, @ColorRes int color, Fragment fragment) {
        this.fragment = fragment;
        item = new AHBottomNavigationItem(title, resource, color);
    }

    public Fragment getFragment() {
        return fragment;
    }

    public AHBottomNavigationItem getItem() {
        return item;
    }
}
