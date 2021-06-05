package com.example.zerolab.Contract;

import com.example.module.base.BasePresenter;
import com.example.module.base.BaseView;
import com.example.module.net.NetCallBack;
import com.example.module.net.ServiceGenerator;
import com.example.zerolab.api.ApiService;
import com.example.zerolab.bean.LabBean;

import retrofit2.Call;
import retrofit2.Response;

/**
 * @author DELL
 */
public class LabQueryContract {
    public static class LabQueryPresenter extends BasePresenter<ILabView> {
        public void getLabQueryResult(String labName){
            ApiService service= ServiceGenerator.createService(ApiService.class);
            service.queryLab(labName).enqueue(new NetCallBack<LabBean>() {
                @Override
                public void onSuccess(Call<LabBean> call, Response<LabBean> response) {
                    if(getView()!=null){
                        getView().getLabQueryResult(response);
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

    public interface ILabView extends BaseView{
        /**
         * 获取单条实验室查询结果
         * @param response
         * */
        void getLabQueryResult(Response<LabBean> response);

        /**
         * 获取失败信息
         * */
        void getFailed();
    }
}
