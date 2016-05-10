package com.rocky.myframework.base;

import android.os.Bundle;
import android.view.View;

import com.rocky.myframework.R;

import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * Created by y7un on 2016/5/3.
 */
public class BaseActivity extends SwipeBackActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.header_back:
                finish();
                break;
            case R.id.header_title:
                break;
        }
    }
}
