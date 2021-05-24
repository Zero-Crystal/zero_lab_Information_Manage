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
public class ReserveCheckAdapter extends BaseQuickAdapter<ReserveCheckBean, BaseViewHolder> {

    public ReserveCheckAdapter(int layoutResId, @Nullable List<ReserveCheckBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ReserveCheckBean item) {
        helper.setText(R.id.tv_item_student_name,item.getStudentName())
                .setText(R.id.tv_item_student_sum,item.getLabName())
                .setText(R.id.tv_item_experimentName,item.getExperimentName())
                .setText(R.id.tv_item_openTime,item.getExperimentStartTime())
                .setText(R.id.tv_item_endTime,item.getExperimentEndTime());
        helper.addOnClickListener(R.id.btn_item_agree);
        helper.addOnClickListener(R.id.btn_item_cancel);
    }
}
