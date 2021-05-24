package com.example.module.mvp;

import android.os.Bundle;

import com.example.module.base.BaseActivity;
import com.example.module.base.BasePresenter;
import com.example.module.base.BaseView;

/**
 * 适用于需要访问网络接口的Activity
 *
 * @author DELL
 */
public abstract class MvpActivity <P extends BasePresenter> extends BaseActivity {
    protected P mPresent;

    @Override
    public void initBeforeView(Bundle savedInstanceState) {
        mPresent=createPresent();
        mPresent.attach((BaseView) this);
    }

    protected abstract P createPresent();

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresent.detach((BaseView) this);
    }
}
