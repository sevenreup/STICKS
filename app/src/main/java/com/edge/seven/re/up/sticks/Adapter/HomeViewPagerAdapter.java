package com.edge.seven.re.up.sticks.Adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.edge.seven.re.up.sticks.Fragment.ChatsFragment;
import com.edge.seven.re.up.sticks.Fragment.HomeFragment;
import com.edge.seven.re.up.sticks.Fragment.ShopFragment;
import com.edge.seven.re.up.sticks.Interfaces.DripFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeViewPagerAdapter extends FragmentPagerAdapter {

    private List<DripFragment> fragmentList = new ArrayList<>();
    private DripFragment current;

    public HomeViewPagerAdapter(FragmentManager fm) {
        super(fm);

        fragmentList.clear();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new ChatsFragment());
        fragmentList.add(new ShopFragment());

    }

    @Override
    public DripFragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public void setPrimaryItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        if (getCurrentFragment() != object)
            current = ((DripFragment) object);
        super.setPrimaryItem(container, position, object);
    }

    public DripFragment getCurrentFragment() {
        return current;
    }
}
