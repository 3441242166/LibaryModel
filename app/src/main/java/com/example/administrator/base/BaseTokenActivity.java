package com.example.administrator.base;

import android.content.Intent;

import com.afollestad.materialdialogs.MaterialDialog;

public abstract class BaseTokenActivity<T extends IBasePresenter> extends BaseMvpActivity<T>{

    public void showTokenErrorDialog(String msg){
        MaterialDialog.Builder builder = new MaterialDialog.Builder(this)
                .title("错误")
                .content(msg)
                .positiveText("重新登陆")
                .cancelable(false)
                .onAny((dialog, which) -> {
                    switch (which){
                        case POSITIVE:
//                            SaveDataUtil.saveToSharedPreferences(this, ApiConstant.USER_TOKEN, "");
//                            SaveDataUtil.saveToSharedPreferences(this, ApiConstant.USER_ROLE, "");
//                            SaveDataUtil.saveToSharedPreferences(this, ApiConstant.TOKEN_TIME,"");
//                            ActivityCollector.finishAll();
//                            startActivity(new Intent(BaseApplication.getContext(), LodingActivity.class));
                            break;
                    }
                });
        builder.build().show();
    }

}
