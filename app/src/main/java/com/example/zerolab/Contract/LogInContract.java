package com.example.zerolab.Contract;

import android.util.Log;

import com.example.module.base.BasePresenter;
import com.example.module.base.BaseView;
import com.example.module.net.NetCallBack;
import com.example.module.net.ServiceGenerator;
import com.example.zerolab.api.ApiService;
import com.example.zerolab.bean.LoginUserBean;

import retrofit2.Call;
import retrofit2.Response;

/**
 * @author DELL
 */
public class LogInContract {
    public static class LogInPresenter extends BasePresenter<ILogInVew> {
        public void getLogInStatus(String userNum, String userPassword,String userStatus) {
            Log.d("TAG", "getLogInStatus: -------------->这里是网络请求");
            ApiService service = ServiceGenerator.createService(ApiService.class);
            service.loginServlet(userNum, userPassword,userStatus).enqueue(new NetCallBack<LoginUserBean>() {
                @Override
                public void onSuccess(Call<LoginUserBean> call, Response<LoginUserBean> response) {
                    if (getView() != null) {
                        Log.d("TAG", "onSuccess: --------------->访问成功");
                        getView().getLoginInformation(response);
                    }
                }

                @Override
                protected void onFailed() {
                    if (getView() != null){
                        Log.d("TAG", "onFailed: --------------->访问失败");
                        getView().getFailed();
                    }
                }
            });
        }
    }

    public interface ILogInVew extends BaseView {
        /**
         * 获取学生登录信息
         *
         * @param response
         */
        void getLoginInformation(Response<LoginUserBean> response);

        /**
         * 错误返回
         */
        void getFailed();
    }
}
