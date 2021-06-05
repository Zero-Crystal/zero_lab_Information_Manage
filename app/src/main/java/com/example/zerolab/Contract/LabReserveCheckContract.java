package com.example.zerolab.Contract;

import com.example.module.base.BasePresenter;
import com.example.module.base.BaseView;
import com.example.module.net.NetCallBack;
import com.example.module.net.ServiceGenerator;
import com.example.zerolab.api.ApiService;
import com.example.zerolab.bean.ReserveCheckBean;
import com.example.zerolab.bean.ResultCheckResponseBean;

import retrofit2.Call;
import retrofit2.Response;

/**
 * @author DELL
 */
public class LabReserveCheckContract {
    public static class LabReservePresenter extends BasePresenter<ILabReserveCheckView>{

        public void getReserveCheckList(){
            ApiService service= ServiceGenerator.createService(ApiService.class);
            service.getReserveCheckList().enqueue(new NetCallBack<ReserveCheckBean>() {
                @Override
                public void onSuccess(Call<ReserveCheckBean> call, Response<ReserveCheckBean> response) {
                    if(getView()!=null){
                        getView().getReserveCheckList(response);
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

        public void editReserveCheck(String stuName,String experimentName,String checkResult,String checkTeacher){
            ApiService service=ServiceGenerator.createService(ApiService.class);
            service.editReserveCheck(stuName,experimentName,checkResult,checkTeacher).enqueue(new NetCallBack<ResultCheckResponseBean>() {
                @Override
                public void onSuccess(Call<ResultCheckResponseBean> call, Response<ResultCheckResponseBean> response) {
                    if(getView()!=null){
                        getView().getCheckResult(response);
                    }
                }

                @Override
                protected void onFailed() {
                    if (getView()!=null){
                        getView().getFailed();
                    }
                }
            });
        }
    }

    public interface ILabReserveCheckView extends BaseView{
        /**
         * 获取未批准的预约请求列表
         * @param response
         * */
        void getReserveCheckList(Response<ReserveCheckBean> response);
        /**
         * 获取预约请求的批准结果
         * @param response
         * */
        void getCheckResult(Response<ResultCheckResponseBean> response);
        /**
         * 获取失败结果
         * */
        void getFailed();
    }
}
