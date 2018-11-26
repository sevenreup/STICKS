package com.edge.seven.re.up.sticks.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.edge.seven.re.up.sticks.Fragment.Registration.Login;
import com.edge.seven.re.up.sticks.Fragment.Registration.Register;

public class RegistrationAdapter extends FragmentPagerAdapter {


    public RegistrationAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i)
        {
            case 0:
                return new Login();
            case 1:
                return new Register();
        default:
            return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
