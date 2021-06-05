package com.example.zerolab.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.zerolab.R;
import com.example.zerolab.bean.LabInformationBean;

import java.util.List;

/**
 * @author zero
 */
public class LabInformationAdapter extends BaseQuickAdapter<LabInformationBean.LabInformation.Labs,BaseViewHolder> {

    public LabInformationAdapter(int layoutResId, @Nullable List<LabInformationBean.LabInformation.Labs> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, LabInformationBean.LabInformation.Labs item) {
        helper.setText(R.id.tv_item_title, item.getLabName());
        helper.setText(R.id.tv_item_introduction,item.getLabIntroduce());
        helper.setText(R.id.tv_item_address,item.getLabAddress());
        helper.setText(R.id.tv_item_openTime,item.getLabOpenTime());
        helper.setText(R.id.tv_item_equip,item.getLabEquip());
        helper.setText(R.id.tv_item_reserve,item.getLabReserve());
        helper.addOnClickListener(R.id.btn_item_submit);
    }
}
