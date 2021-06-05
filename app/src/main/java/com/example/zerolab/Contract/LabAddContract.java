package com.example.zerolab.Contract;

import com.example.module.base.BasePresenter;
import com.example.module.base.BaseView;
import com.example.module.net.NetCallBack;
import com.example.module.net.ServiceGenerator;
import com.example.zerolab.api.ApiService;
import com.example.zerolab.bean.LabInsertResponseBean;

import retrofit2.Call;
import retrofit2.Response;

/**
 * @author zero
 */
public class LabAddContract {
    public static class LabAddPresenter extends BasePresenter<ILabAddView>{
        public void insetLabInformation(String labNum,String labName,String labAddress,String labIntroduce,
                                        String labSum,String labEquip,String labTime){
            ApiService service= ServiceGenerator.createService(ApiService.class);
            service.insertLabInformation(labNum,labName,labIntroduce,labAddress,labTime,labSum,labEquip).enqueue(new NetCallBack<LabInsertResponseBean>() {
                @Override
                public void onSuccess(Call<LabInsertResponseBean> call, Response<LabInsertResponseBean> response) {
                    if(getView()!=null){
                        getView().getLabInsertResult(response);
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

    public interface ILabAddView extends BaseView {
        /**
         * 获取实验室信息插入结果
         * @param response
         * */
        void getLabInsertResult(Response<LabInsertResponseBean> response);
        void getFailed();
    }
}
