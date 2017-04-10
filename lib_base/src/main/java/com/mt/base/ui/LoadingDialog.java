package com.mt.base.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;

import com.mt.base.R;

/**
 * Created by xianguo on 6/4/17.
 * 加载中对话框
 */

public class LoadingDialog extends AlertDialog {
    protected LoadingDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_view_loading_dialog);
    }
}
