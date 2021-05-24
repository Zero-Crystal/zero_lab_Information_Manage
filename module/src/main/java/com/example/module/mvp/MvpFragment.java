package com.example.module.mvp;

import android.os.Bundle;

import com.example.module.base.BaseFragment;
import com.example.module.base.BasePresenter;
import com.example.module.base.BaseView;

/**
 * 需要网络请求的Fragment
 * @author DELL
 */
public abstract class MvpFragment <P extends BasePresenter> extends BaseFragment {
    protected P mPresent;
    @Override
    public void initBeforeView(Bundle savedInstanceState) {
        mPresent=createPresent();
        mPresent.attach((BaseView) this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (mPresent!=null){
            mPresent.detach((BaseView) this);
        }
    }

    /**
     * @describe 创建presenter
     */
    protected abstract P createPresent();
}
