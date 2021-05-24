package com.example.zerolab.Contract;

import android.content.Context;

import com.example.module.base.BasePresenter;
import com.example.module.base.BaseView;
import com.example.module.net.NetCallBack;
import com.example.module.net.ServiceGenerator;
import com.example.zerolab.api.ApiService;
import com.example.zerolab.bean.LabBean;

import retrofit2.Call;
import retrofit2.Response;

/**
 * @author zero
 */
public class WeatherContract {

    public static class WeatherPresenter extends BasePresenter<IWeatherView> {
        /**
         * 当日天气
         *
         * @param context
         * @param location 区/县
         */
        public void todayWeather(final Context context, String location) {
            //得到构建之后的网络请求服务，这里的地址已经拼接完成，只差一个location了
            ApiService service = ServiceGenerator.createService(ApiService.class);
            //设置请求回调  NetCallBack是重写请求回调
            service.getTodayWeather(location).enqueue(new NetCallBack<LabBean>() {
                @Override
                public void onSuccess(Call<LabBean> call, Response<LabBean> response) {
                    if (getView() != null) {//当视图不会空时返回请求数据
                        getView().getTodayWeatherResult(response);
                    }
                }

                @Override
                protected void onFailed() {
                    if (getView() != null) {//当视图不会空时获取错误信息
                        getView().getDataFailed();
                    }
                }
            });
        }
    }

    public interface IWeatherView extends BaseView {
        //将数据放入实体
        void getTodayWeatherResult(Response<LabBean> response);

        //错误返回
        void getDataFailed();
    }
}
