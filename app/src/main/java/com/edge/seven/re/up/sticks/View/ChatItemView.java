package com.edge.seven.re.up.sticks.View;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.epoxy.ModelProp;
import com.airbnb.epoxy.ModelView;
import com.airbnb.paris.annotations.Style;
import com.airbnb.paris.annotations.Styleable;
import com.edge.seven.re.up.sticks.R;

import javax.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;

@Styleable
@ModelView(defaultLayout = R.layout.model_chat_view)
public class ChatItemView extends CardView {

    @BindView(R.id.message_text)
    TextView messageText;
    @BindView(R.id.message_img)
    ImageView profileImage;
    @BindView(R.id.user_name) TextView username;
    @BindView(R.id.location) TextView location;
    @BindView(R.id.time_stamp) TextView time;

    public ChatItemView(Context context) {
        super(context);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_chat, this);
        ButterKnife.bind(this);
    }

    @Style(isDefault = true)
    static void chatStyle(ChatItemViewStyleApplier.StyleBuilder builder)
    {
        builder.layoutWidth(ViewGroup.LayoutParams.MATCH_PARENT).layoutHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @ModelProp(options = ModelProp.Option.DoNotHash)
    public void setProfileImage(@DrawableRes int res)
    {
        profileImage.setImageResource(res);
    }

    @ModelProp(options = ModelProp.Option.DoNotHash)
    public void setUsername(CharSequence username) {
        this.username.setText(username);
    }

    @ModelProp(options = ModelProp.Option.DoNotHash)
    public void setLocation(CharSequence location) {
        this.location.setText(location);
    }

    @ModelProp(options = ModelProp.Option.DoNotHash)
    public void setTime(int time) {
        this.time.setText(String.valueOf(time));
    }

    @ModelProp(options = ModelProp.Option.GenerateStringOverloads)
    public void setMessageText(CharSequence messageText)
    {
        this.messageText.setText(messageText);
    }

    @ModelProp(options = {ModelProp.Option.DoNotHash})
    public void onClick(@Nullable View.OnClickListener listener)
    {
        this.setOnClickListener(listener);
    }
}
