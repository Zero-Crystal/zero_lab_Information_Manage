package com.example.zerolab.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.zerolab.bean.LabBean;

import java.util.List;

/**
 * @author yating
 */
public class LabInformationAdapter extends BaseQuickAdapter<LabBean,BaseViewHolder> {

    public LabInformationAdapter(int layoutResId, @Nullable List<LabBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, LabBean item) {

    }
}
