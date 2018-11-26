package com.edge.seven.re.up.sticks.Controller;

import com.airbnb.epoxy.EpoxyController;
import com.edge.seven.re.up.sticks.Interfaces.MChats;
import com.edge.seven.re.up.sticks.Model.ChatModelGroup;

import java.util.List;

public class ChatsController extends EpoxyController {

    private List<MChats> chats;
    private AdapterCallback adapterCallback;

    public interface AdapterCallback
    {
        void onClick(String item);
    }

    public ChatsController(List<MChats> chats, AdapterCallback adapterCallback)
    {
        this.chats = chats;
        this.adapterCallback = adapterCallback;
    }

    @Override
    protected void buildModels() {
        add(new ChatModelGroup(chats, adapterCallback));
    }
}
