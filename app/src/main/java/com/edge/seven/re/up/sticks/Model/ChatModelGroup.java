package com.edge.seven.re.up.sticks.Model;

import com.airbnb.epoxy.EpoxyModel;
import com.airbnb.epoxy.EpoxyModelGroup;
import com.edge.seven.re.up.sticks.Controller.ChatsController.AdapterCallback;
import com.edge.seven.re.up.sticks.Interfaces.MChats;
import com.edge.seven.re.up.sticks.R;
import com.edge.seven.re.up.sticks.View.ChatItemViewModel_;

import java.util.ArrayList;
import java.util.List;

public class ChatModelGroup extends EpoxyModelGroup {

    public ChatModelGroup(List<MChats> chats, AdapterCallback callback) {
        super(R.layout.model_chats_group_item_view, buildModels(chats, callback));
    }

    @Override
    public int getSpanSize(int totalSpanCount, int position, int itemCount) {
        return totalSpanCount;
    }

    private static List<EpoxyModel<?>> buildModels(List<MChats> chats, AdapterCallback callback) {
        ArrayList<EpoxyModel<?>> models = new ArrayList<>();
        for (int i = 0; i < chats.size(); i++) {
            final int m = i;
            models.add(new ChatItemViewModel_()
                    .onClick(view -> callback.onClick(chats.get(m).getMessage()))
                    .messageText(chats.get(i).getMessage())
                    .profileImage(R.drawable.ic_profile)
                    .location(chats.get(i).getLocation())
                    .username(chats.get(i).getName())
                    .time(chats.get(i).getTime()));
        }
        return models;
    }
}
