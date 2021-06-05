package com.example.zerolab.Contract;

import com.example.module.base.BasePresenter;
import com.example.module.base.BaseView;
import com.example.module.net.NetCallBack;
import com.example.module.net.ServiceGenerator;
import com.example.zerolab.api.ApiService;
import com.example.zerolab.bean.ResultBean;

import retrofit2.Call;
import retrofit2.Response;

/**
 * @author DELL
 */
public class ReserveContract {
    public static class ReservePresenter extends BasePresenter<IReserveView> {
        public void insertReserve(String stuName, String stuNum, String labName,
                                  String experimentName,String stuSum,String experimentTime){
            ApiService service= ServiceGenerator.createService(ApiService.class);
            service.insertReserve(stuName,stuNum,labName,experimentName,stuSum,experimentTime).enqueue(new NetCallBack<ResultBean>() {
                @Override
                public void onSuccess(Call<ResultBean> call, Response<ResultBean> response) {
                    if(getView()!=null){
                        getView().getReserveResult(response);
                    }
                }

                @Override
                protected void onFailed() {
                    if(getView()!=null){
                        getView().Failed();
                    }
                }
            });
        }
    }

    public interface IReserveView extends BaseView{
        /**
         * 获得预约结果
         * @param response
         * */
        void getReserveResult(Response<ResultBean> response);

        /**
         * 失败结果返回
         * */
        void Failed();
    }
}
