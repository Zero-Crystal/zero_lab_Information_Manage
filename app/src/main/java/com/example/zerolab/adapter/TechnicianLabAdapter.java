package com.example.zerolab.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.zerolab.R;
import com.example.zerolab.bean.LabBean;

import java.util.List;

/**
 * @author zero
 */
public class TechnicianLabAdapter extends BaseQuickAdapter<LabBean, BaseViewHolder> {
    public TechnicianLabAdapter(int layoutResId, @Nullable List<LabBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, LabBean item) {
        helper.setText(R.id.tv_item_title,item.getLabName())
                .setText(R.id.tv_item_introduction,item.getLabIntroduce())
                .setText(R.id.tv_item_address,item.getLabAddress())
                .setText(R.id.tv_item_openTime,item.getLabOpenTime())
                .setText(R.id.tv_item_equip,item.getLabEquip())
                .setText(R.id.tv_item_reserve,item.getLabReserve());
    }
}
