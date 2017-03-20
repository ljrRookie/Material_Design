package com.example.material_design.Utils;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

/**
 * Created by user on 2017/3/20.
 */

public class SnackbarUtils {
    //可交互提示工具
    public static void showSnackbar(final Context context, View view, String text, final String action){
        Snackbar.make(view,text,Snackbar.LENGTH_LONG)
                .setAction(action, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtils.showToast(context,action);
                    }
                }).setActionTextColor(Color.RED).show();

    }
}
