package com.example.zerolab.Contract;

import com.example.module.base.BasePresenter;
import com.example.module.base.BaseView;
import com.example.module.net.NetCallBack;
import com.example.module.net.ServiceGenerator;
import com.example.zerolab.api.ApiService;
import com.example.zerolab.bean.ReserveResultBean;

import retrofit2.Call;
import retrofit2.Response;

/**
 * @author DELL
 */
public class ResultContract {
    public static class ResultPresenter extends BasePresenter<IResultView>{
        public void getReserveResult(String stuNum){
            ApiService service= ServiceGenerator.createService(ApiService.class);
            service.queryStuResult(stuNum).enqueue(new NetCallBack<ReserveResultBean>() {
                @Override
                public void onSuccess(Call<ReserveResultBean> call, Response<ReserveResultBean> response) {
                    if(getView()!=null){
                        getView().getReserveResult(response);
                    }
                }

                @Override
                protected void onFailed() {
                    if(getView()!=null){
                        getView().getFailed();
                    }
                }
            });
        }
    }

    public interface IResultView extends BaseView{
        void getReserveResult(Response<ReserveResultBean> response);

        void getFailed();
    }
}
