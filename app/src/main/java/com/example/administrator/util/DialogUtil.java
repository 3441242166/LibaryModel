package com.example.administrator.util;

import android.content.Context;
import android.text.InputType;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.administrator.libarymodel.R;

public class DialogUtil {

    Context context;

    void progressDialog(){
        new MaterialDialog.Builder(context)
                .title("Progress")
                .content("Please Wait...")
                .progress(true, 0)
                .show();
    }

    void inputDialog(){
        new MaterialDialog.Builder(context)
                .title("Title")
                .inputRangeRes(2, 20, R.color.colorAccent)
                .inputType(InputType.TYPE_CLASS_TEXT)
                .input("说点什么", null, new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(MaterialDialog dialog, CharSequence input) {

                    }
                })
                .positiveText("确定")
                .show();
    }

}
