package com.example.zerolab.Contract;

import com.example.module.base.BasePresenter;
import com.example.module.base.BaseView;
import com.example.module.net.NetCallBack;
import com.example.module.net.ServiceGenerator;
import com.example.zerolab.api.ApiService;
import com.example.zerolab.bean.LabInformationBean;

import retrofit2.Call;
import retrofit2.Response;

/**
 * @author DELL
 */
public class LabInformationContract {
    public static class LabInformationPresenter extends BasePresenter<ILabInformationVew> {
        /**
         * 获取实验室信息列表
         * */
        public void LabInformation(){
            ApiService service= ServiceGenerator.createService(ApiService.class);
            service.labInformationServlet().enqueue(new NetCallBack<LabInformationBean>() {
                @Override
                public void onSuccess(Call<LabInformationBean> call, Response<LabInformationBean> response) {
                    if (getView()!=null){
                        getView().getLabInformation(response);
                    }
                }

                @Override
                protected void onFailed() {
                    if (getView()!=null){
                        getView().Failed();
                    }
                }
            });
        }
    }

    public interface ILabInformationVew extends BaseView {
        /**
         * 获取实验室信息列表，并更新视图
         * @param labInformationBeanResponse
         * */
        void getLabInformation(Response<LabInformationBean> labInformationBeanResponse);

        /**服务器访问失败*/
        void Failed();
    }
}
