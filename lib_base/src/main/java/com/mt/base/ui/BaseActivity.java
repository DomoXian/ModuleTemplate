package com.mt.base.ui;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mt.base.helper.ActivityStackHelper;

/**
 * Created by xianguo on 6/4/17.
 * activity 基类
 */

@SuppressWarnings("unused")
public class BaseActivity extends AppCompatActivity {

    protected boolean mIsHide;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityStackHelper.push(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsHide = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityStackHelper.pop(this);
        mIsHide = true;
    }


    @Override
    protected void onStop() {
        super.onStop();
        mIsHide = true;
    }

    /*************动态赋值**************/

    @SuppressWarnings("unchecked")
    public <T extends View> T $$(@LayoutRes int id) {
        return (T) getLayoutInflater().inflate(id, null);
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T $(@IdRes int id) {
        return (T) super.findViewById(id);
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T $(View view, @IdRes int id) {
        return (T) view.findViewById(id);
    }
}
