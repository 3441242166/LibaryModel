package com.example.administrator.libarymodel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.net.RetrofitClient;
import com.example.net.RetrofitCreator;
import com.example.net.callback.IError;
import com.example.net.callback.IFailure;
import com.example.net.callback.ISuccess;
import com.example.net.rx.RxRetrofitClient;
import com.example.projectcore.Config;
import com.example.ui.Loader;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RetrofitClient.builder()
                .loader(this,null)
                .url("https://www.baidu.com/")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Toast.makeText(MainActivity.this,response,Toast.LENGTH_SHORT).show();
                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {
                        Toast.makeText(MainActivity.this,"onError",Toast.LENGTH_SHORT).show();
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {
                        Toast.makeText(MainActivity.this,"onFailure",Toast.LENGTH_SHORT).show();
                    }
                })
                .build()
                .get();

        RxRetrofitClient.builder()
                .loader(this,null)
                .url("https://www.baidu.com/")
                .build()
                .get()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });

        RetrofitCreator.getRxRetrofitService().get("",null)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });

    }
}
