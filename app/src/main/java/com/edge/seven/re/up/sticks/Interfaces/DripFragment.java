package com.edge.seven.re.up.sticks.Interfaces;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.edge.seven.re.up.sticks.R;

public class DripFragment extends Fragment {
    private View frameLayout;

    public void setFrameLayout(View frameLayout) {
        this.frameLayout = frameLayout;
    }

    public void willBeDisplayed()
    {
        if (frameLayout != null)
        {
            Animation fadeIn = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in);
            frameLayout.setAnimation(fadeIn);
        }
    }

    public void willBeHidden()
    {
        if (frameLayout != null)
        {
            Animation fadeOut = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_out);
            frameLayout.setAnimation(fadeOut);
        }
    }
}
