package com.example.zerolab.fragment.technician;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.module.mvp.MvpFragment;
import com.example.zerolab.Contract.StudentIndexContract;
import com.example.zerolab.R;
import com.example.zerolab.adapter.ReserveCheckAdapter;
import com.example.zerolab.bean.ReserveCheckBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zero
 */
public class ReserveCheckFragment extends MvpFragment<StudentIndexContract.StudentIndexPresenter> implements StudentIndexContract.IStudentIndex {
    private RecyclerView rvReserveCheck;
    private List<ReserveCheckBean> checkBeanList = new ArrayList<>();
    private final int btnAgree = R.id.btn_item_agree;
    private final int btnCancel = R.id.btn_item_cancel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.module_fragment_technician_reserve_check, container, false);

        rvReserveCheck = view.findViewById(R.id.rv_technician_reserve_check);
        ReserveCheckAdapter checkAdapter = new ReserveCheckAdapter(R.layout.module_recycler_item_reserve_check, checkBeanList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        rvReserveCheck.setLayoutManager(layoutManager);
        rvReserveCheck.setAdapter(checkAdapter);
        checkAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case btnAgree:
                        //TODO
                        Toast.makeText(getContext(), "通过预约", Toast.LENGTH_SHORT).show();
                        break;
                    case btnCancel:
                        //TODO
                        Toast.makeText(getContext(), "取消预约", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });

        return view;
    }

    @Override
    protected StudentIndexContract.StudentIndexPresenter createPresent() {
        return new StudentIndexContract.StudentIndexPresenter();
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        ReserveCheckBean bean=new ReserveCheckBean();
        bean.setStudentName("李明");
        bean.setLabName("光学实验室");
        bean.setExperimentSum("36");
        bean.setExperimentStartTime("14:00");
        bean.setExperimentEndTime("16:00");
        bean.setExperimentName("小孔成像");
        checkBeanList.add(bean);
    }
}
