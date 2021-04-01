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
public class ReserveResultAdapter extends BaseQuickAdapter<ReserveResultBean, BaseViewHolder> {

    public ReserveResultAdapter(int layoutResId, @Nullable List<ReserveResultBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ReserveResultBean item) {
        helper.setText(R.id.tv_item_title,item.getLabName())
                .setText(R.id.tv_item_experimentName,item.getExperimentName())
                .setText(R.id.tv_item_startTime,item.getStartTime())
                .setText(R.id.tv_item_endTime,item.getEndTime())
                .setText(R.id.tv_item_reserveResult,item.getReserveResult())
                .setText(R.id.tv_item_reserveTeacher,item.getReserveTeacher());
        helper.addOnClickListener(R.id.btn_item_cancel);
    }
}
