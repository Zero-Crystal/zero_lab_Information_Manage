package com.example.zerolab.Contract;

import com.example.module.base.BasePresenter;
import com.example.module.base.BaseView;
import com.example.module.net.ServiceGenerator;
import com.example.zerolab.api.ApiService;

/**
 * @author zero
 */
public class StudentIndexContract {
    public static class StudentIndexPresenter extends BasePresenter<IStudentIndex>{
        ApiService service= ServiceGenerator.createService(ApiService.class);
    }

    public interface IStudentIndex extends BaseView {

    }
}
