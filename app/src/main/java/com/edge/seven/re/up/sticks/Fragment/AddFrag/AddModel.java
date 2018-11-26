package com.edge.seven.re.up.sticks.Fragment.AddFrag;

import com.edge.seven.re.up.sticks.R;

public enum  AddModel {
    TEMPLATE(R.layout.container_add_template),
    NORMAL(R.layout.container_add_normal);

    private int layout;
    AddModel(int layout)
    {
        this.layout = layout;
    }

    public int getLayout() {
        return layout;
    }
}
