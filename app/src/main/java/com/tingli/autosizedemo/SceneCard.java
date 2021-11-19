package com.tingli.autosizedemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SceneCard extends RelativeLayout {
    private View rootView;
    private int backgroundId, iconId;
    private String title;
    private ImageView iv_icon;
    private TextView tv_title;

    public SceneCard(Context context) {
        this(context, null);
    }

    public SceneCard(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public SceneCard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//                rootView = LayoutInflater.from(context).inflate(R.layout.layout_scene_card, this);
        rootView = LayoutInflater.from(context).inflate(R.layout.layout_scene_card_autosize, this);
        TypedArray ta = context.getTheme().obtainStyledAttributes(attrs, R.styleable.SceneCard, 0, 0);
        int n = ta.getIndexCount();
        for (int i = 0; i < n; i++)
        {
            int index = ta.getIndex(i);
            switch (index)
            {
                case R.styleable.SceneCard_background:
                    backgroundId = ta.getResourceId(index, -1);
                    break;
                case R.styleable.SceneCard_icon:
                    iconId = ta.getResourceId(index, -1);
                    break;
                case R.styleable.SceneCard_title:
                    title = ta.getString(index);
                    break;
                default:
            }
        }
        ta.recycle();
        initView();
    }

    private void initView() {
        if (backgroundId != -1)
        {
            setBackgroundResource(backgroundId);
        }
        iv_icon = rootView.findViewById(R.id.iv_icon);
        if (iconId != -1)
        {
            iv_icon.setImageResource(iconId);
        }
        tv_title = rootView.findViewById(R.id.tv_title);
        if (!TextUtils.isEmpty(title))
        {
            tv_title.setText(title);
        }
    }

    public void setTitle(String text) {
        tv_title.setText(text);
    }

    public String getTitle() {
        return tv_title.getText().toString();
    }

    private boolean isSelected = false;

    @Override
    public void setSelected(boolean selected) {
        this.isSelected = selected;
        if (selected)
        {
            super.setSelected(true);
            //            iv_icon.setSelected(true);
            //            tv_title.setSelected(true);
        }
        else
        {
            super.setSelected(false);
            //            iv_icon.setSelected(false);
            //            tv_title.setSelected(false);
        }
    }

    @Override
    public boolean isSelected() {
        return isSelected;
    }

    private boolean isEnabled = true;

    @Override
    public void setEnabled(boolean enabled) {
        this.isEnabled = enabled;
        iv_icon.setEnabled(enabled);
        tv_title.setEnabled(enabled);
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

}