package com.example.zerolab.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.zerolab.R;
import com.example.zerolab.bean.ReserveCheckBean;

import java.util.List;

/**
 * @author zero
 */
public class ReserveCheckAdapter extends BaseQuickAdapter<ReserveCheckBean.Results.ResultList, BaseViewHolder> {

    public ReserveCheckAdapter(int layoutResId, @Nullable List<ReserveCheckBean.Results.ResultList> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ReserveCheckBean.Results.ResultList item) {
        helper.setText(R.id.tv_item_student_name,item.getStuName())
                .setText(R.id.tv_item_lab_name,item.getLabName())
                .setText(R.id.tv_item_student_sum,item.getStuSum())
                .setText(R.id.tv_item_experimentName,item.getExperimentName())
                .setText(R.id.tv_item_openTime,item.getExperimentTime());
        helper.addOnClickListener(R.id.btn_item_agree);
        helper.addOnClickListener(R.id.btn_item_cancel);
    }
}
