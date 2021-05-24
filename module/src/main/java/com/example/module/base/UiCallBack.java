package com.example.module.base;

import android.os.Bundle;

/**
 * UI回调接口
 *
 * @author zero
 */
public interface UiCallBack {
    /**
     * 初始化savedInstanceState
     * */
    void initBeforeView(Bundle savedInstanceState);

    /**
     * 初始化
     * */
    void initData(Bundle savedInstanceState);
}
