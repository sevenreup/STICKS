package com.edge.seven.re.up.sticks.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.edge.seven.re.up.sticks.Activity.DirectMessage;
import com.edge.seven.re.up.sticks.Controller.ChatsController;
import com.edge.seven.re.up.sticks.Interfaces.DripFragment;
import com.edge.seven.re.up.sticks.Interfaces.MChats;
import com.edge.seven.re.up.sticks.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.edge.seven.re.up.sticks.Helper.CONSTANTS.USERNAME;

public class ChatsFragment extends DripFragment implements ChatsController.AdapterCallback {

    @BindView(R.id.profileframe)
    FrameLayout frameLayout;
    @BindView(R.id.reccc)
    RecyclerView recyclerView;
    List<MChats> chats;
    ChatsController chatsController;

    public ChatsFragment() {
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        ButterKnife.bind(this, v);
        setFrameLayout(frameLayout);
        setData();
        chatsController = new ChatsController(chats, this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(chatsController.getAdapter());
        chatsController.requestModelBuild();
        return v;
    }

    void setData() {
        chats = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            chats.add(new MChats("Message" + i, "Name " + i, "Location " + i, i));
    }

    @Override
    public void onClick(String item) {
        startActivity(new Intent(getActivity(), DirectMessage.class).putExtra(USERNAME, item));
    }

}
