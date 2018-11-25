package com.example.net.rx;

import android.content.Context;

import com.example.net.RetrofitClient;
import com.example.net.callback.IError;
import com.example.net.callback.IFailure;
import com.example.net.callback.IRequest;
import com.example.net.callback.ISuccess;
import com.example.ui.LoaderStyle;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class RxRetrofitClientBuilder {

    private  String mUrl;
    private  Map<String,Object> mParams;
    private  RequestBody mRequestBody;
    private  File file;
    private  LoaderStyle loaderStyle;
    private  Context context;

    public final RxRetrofitClientBuilder url(String mUrl){
        this.mUrl = mUrl;
        return this;
    }

    public final RxRetrofitClientBuilder file(String file){
        this.file = new File(file);
        return this;
    }

    public final RxRetrofitClientBuilder file(File file){
        this.file = file;
        return this;
    }

    public final RxRetrofitClientBuilder params(Map<String,Object> mParams){
        this.mParams = mParams;
        return this;
    }

    public final RxRetrofitClientBuilder params(String key, Object val){
        if(mParams == null){
            mParams = new HashMap<>();
        }
        this.mParams.put(key,val);
        return this;
    }

    public final RxRetrofitClientBuilder raw(String raw){
        this.mRequestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"),raw);
        return this;
    }


    public final RxRetrofitClientBuilder loader(Context context, LoaderStyle loaderStyle){
        this.context = context;
        this.loaderStyle = loaderStyle;
        return this;
    }

    private void check(){
        if(mParams == null){
            mParams = new HashMap<>();
        }
    }

    public final RxRetrofitClient build(){
        check();
        return new RxRetrofitClient(mUrl,
                mParams,
                mRequestBody,
                file,
                context,
                loaderStyle);
    }
}
