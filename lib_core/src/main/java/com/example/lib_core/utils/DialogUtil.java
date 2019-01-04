package com.example.lib_core.utils;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

public class DialogUtil extends ProgressDialog {
    public DialogUtil( Context context) {
        super(context);
    }

    public DialogUtil(Context context, int themeResId) {
        super(context, themeResId);
    }


}
