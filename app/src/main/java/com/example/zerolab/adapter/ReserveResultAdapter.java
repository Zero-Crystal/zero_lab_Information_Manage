package com.example.zerolab.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.zerolab.R;
import com.example.zerolab.bean.ReserveResultBean;

import java.util.List;

/**
 * @author zero
 */
public class ReserveResultAdapter extends BaseQuickAdapter<ReserveResultBean.Results.Result, BaseViewHolder> {

    public ReserveResultAdapter(int layoutResId, @Nullable List<ReserveResultBean.Results.Result> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ReserveResultBean.Results.Result item) {
        helper.setText(R.id.tv_item_title,item.getLabName())
                .setText(R.id.tv_item_experimentName,item.getExperimentName())
                .setText(R.id.tv_item_startTime,item.getExperimentTime())
                .setText(R.id.tv_item_reserveResult,item.getReserveStatus())
                .setText(R.id.tv_item_reserveTeacher,item.getCheckTeacher());
    }
}
