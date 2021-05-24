package com.example.module.net;

import android.util.Log;

import com.example.module.base.BaseResponse;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author DELL
 */
public abstract class NetCallBack<T> implements Callback<T> {
    private final int NOT_FOND = 404;
    private final int INTERNAL_SERVER_ERROR = 500;

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        //数据返回
        if (response != null && response.body() != null && response.isSuccessful()) {
            BaseResponse baseResponse = new Gson().fromJson(new Gson().toJson(response.body()), BaseResponse.class);
            if (baseResponse.getCode() == NOT_FOND) {
                Log.e("Warn", baseResponse.getData().toString());
            } else if (baseResponse.getCode() == INTERNAL_SERVER_ERROR) {
                Log.e("Warn", baseResponse.getData().toString());
            } else {//无异常则返回数据
                onSuccess(call, response);
                Log.e("Warn", "其他情况");
            }
        } else {
            onFailed();
        }
    }

    /**
     * @function 访问失败回调
     */
    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onFailed();
    }

    /**
     * @function 数据返回
     */
    public abstract void onSuccess(Call<T> call, Response<T> response);

    /**
     * @function 失败异常
     */
    protected abstract void onFailed();
}
