package com.rocky.myframework;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.rocky.myframework.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AboutActivity extends BaseActivity {

    @Bind(R.id.header_title)
    TextView headerTitle;
    @Bind(R.id.header_back)
    ImageButton headerBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        headerBack.setOnClickListener(this);
        headerTitle.setOnClickListener(this);
        headerTitle.setText("关于");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

}
