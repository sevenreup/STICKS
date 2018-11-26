package com.edge.seven.re.up.sticks.Activity;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.edge.seven.re.up.sticks.Controller.SingleDMController;
import com.edge.seven.re.up.sticks.Fragment.AddFrag.AddDMFragment;
import com.edge.seven.re.up.sticks.Interfaces.MMessage;
import com.edge.seven.re.up.sticks.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.text.TextUtils.isEmpty;
import static com.edge.seven.re.up.sticks.Helper.CONSTANTS.USERNAME;

public class DirectMessage extends AppCompatActivity implements SingleDMController.AdapterCallbacks {
    boolean toogleAdd = false;
    @BindView(R.id.edit_message)
    EditText messageBox;
    @BindView(R.id.add_container)
    View view;
    @BindView(R.id.send)
    ImageView sendButton;
    @BindView(R.id.dm_toolbar)
    Toolbar toolbar;
    @BindView(R.id.recy)
    RecyclerView recyclerView;
    SingleDMController controller = new SingleDMController(this);
    AddDMFragment addDMFragment;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direct_message);
        String name = getIntent().getStringExtra(USERNAME);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(name);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(controller.getAdapter());
        updateController();
        setOnTypeListener();
        setAddDMFragment();
    }

    private void updateController() {
        controller.setData(data());
    }

    private List<MMessage> data()
    {
        List<MMessage> data = new ArrayList<>();
        for(int i = 0; i < 50; i++)
            data.add(new MMessage("this is the message " + i, "type", 122 + i, true));
        return data;
    }

    private void setOnTypeListener()
    {
        messageBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                if(!isEmpty(s))
                {
                    sendButton.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent), PorterDuff.Mode.SRC_IN));
                } else
                {
                    sendButton.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark), PorterDuff.Mode.SRC_IN));
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!isEmpty(s))
                {
                    sendButton.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent), PorterDuff.Mode.SRC_IN));
                } else
                {
                    sendButton.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark), PorterDuff.Mode.SRC_IN));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!isEmpty(s))
                {
                    sendButton.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent), PorterDuff.Mode.SRC_IN));
                } else
                {
                    sendButton.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark), PorterDuff.Mode.SRC_IN));
                }
            }
        });
    }

    private void setAddDMFragment()
    {
        addDMFragment = new AddDMFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.add_container, addDMFragment).commit();
    }

    @OnClick(R.id.add_btn)
    public void showAddOption()
    {
        if(!toogleAdd)
        {
            view.setVisibility(View.VISIBLE);
            toogleAdd = true;
        } else {
            view.setVisibility(View.GONE);
            toogleAdd = false;
        }

    }
}
