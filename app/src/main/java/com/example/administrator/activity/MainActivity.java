package com.example.administrator.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.administrator.libarymodel.R;
import com.example.net.rx.RxRetrofitClient;
import com.example.util.SharedPreferencesHelper;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
