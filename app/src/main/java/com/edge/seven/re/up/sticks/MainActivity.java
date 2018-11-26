package com.edge.seven.re.up.sticks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;
import com.edge.seven.re.up.sticks.Activity.LaunchActivity;
import com.edge.seven.re.up.sticks.Adapter.HomeViewPagerAdapter;
import com.edge.seven.re.up.sticks.Interfaces.DripFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements AHBottomNavigation.OnTabSelectedListener {

    @BindView(R.id.bottom_navigation) AHBottomNavigation bottomNavigation;
    @BindView(R.id.bottom_viewpager)
    AHBottomNavigationViewPager viewPager;
    @BindView(R.id.main_page_toolbar) Toolbar toolbar;
    HomeViewPagerAdapter adapter;

    DripFragment currentFragment;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        mAuth = FirebaseAuth.getInstance();
        initUI();
    }

    @Override
    public boolean onTabSelected(int position, boolean wasSelected) {
        if (currentFragment == null)
            currentFragment = adapter.getCurrentFragment();

        if (currentFragment != null)
            currentFragment.willBeHidden();

        viewPager.setCurrentItem(position, false);
        setToolbarTitle(position);

        if (currentFragment == null)
            return true;

        currentFragment = adapter.getCurrentFragment();
        currentFragment.willBeDisplayed();

        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null)
        {
            sendStart();
        }
    }

    private void sendStart() {
        startActivity(new Intent(this, LaunchActivity.class));
    }

    private void initUI(){
        // int[] tabColors = getApplicationContext().getResources().getIntArray(R.array.tab_colors);
        AHBottomNavigationAdapter navigationAdapter = new AHBottomNavigationAdapter(this, R.menu.bottom_navigation_menu);
        navigationAdapter.setupWithBottomNavigation(bottomNavigation);

        setToolbarTitle(0);
        bottomNavigation.setOnTabSelectedListener(this);
        bottomNavigation.setAccentColor(R.color.colorAccent);
        viewPager.setOffscreenPageLimit(4);
        adapter = new HomeViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

    }

    private void setToolbarTitle(int position)
    {
        switch (position)
        {
            case 0:
                getSupportActionBar().setTitle(getString(R.string.home_fragment));
                break;
            case 1:
                getSupportActionBar().setTitle(getString(R.string.chats_fragment));
                break;
            case 2:
                getSupportActionBar().setTitle(getString(R.string.profile_fragment));
                break;
        }
    }
}
