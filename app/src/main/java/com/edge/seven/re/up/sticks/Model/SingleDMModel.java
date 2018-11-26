package com.edge.seven.re.up.sticks.Model;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyModel;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.edge.seven.re.up.sticks.R;

import butterknife.BindView;

import static com.edge.seven.re.up.sticks.Helper.CONSTANTS.MS_REC;
import static com.edge.seven.re.up.sticks.Helper.CONSTANTS.MS_SENT;

@EpoxyModelClass(layout = R.layout.chat_item_other)
public abstract class SingleDMModel extends EpoxyModelWithHolder<SingleDMModel.DMViewHolder> {
    @EpoxyAttribute String timeStamp;
    @EpoxyAttribute String message;
    @EpoxyAttribute String image;
    @EpoxyAttribute int type;
    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    View.OnClickListener listener;

    @Override
    public void bind(@NonNull DMViewHolder holder) {
        holder.message.setText(message);
        holder.timeStamp.setText(timeStamp);
        holder.container.setOnClickListener(listener);
        setMessageType(holder);
    }

    @Override
    public void bind(@NonNull DMViewHolder holder, @NonNull EpoxyModel<?> previouslyBoundModel) {
        super.bind(holder, previouslyBoundModel);
    }

    private void setMessageType(DMViewHolder holder)
    {
        switch (type)
        {
            case MS_SENT:
                holder.parent.setPadding(72, 0, 16, 0);
                break;
            case MS_REC:
                holder.parent.setPadding(16, 0, 72, 0);
                break;
                default:
                    holder.parent.setPadding(R.dimen.ms_r_pad_start, 0, R.dimen.ms_r_pad_end, 0);
                    break;
        }
    }

    @Override
    public void unbind(@NonNull DMViewHolder holder) {
        super.unbind(holder);
    }

    public static class DMViewHolder extends BaseEpoxyViewHolder
    {
        @BindView(R.id.message_container)
        FrameLayout parent;
        @BindView(R.id.chat_container)
        CardView container;
        @BindView(R.id.profileimg)
        ImageView profileIMG;
        @BindView(R.id.time_stamp)
        TextView timeStamp;
        @BindView(R.id.message)
        TextView message;
    }

}
