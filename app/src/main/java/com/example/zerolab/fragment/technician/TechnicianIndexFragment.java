package com.example.zerolab.fragment.technician;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.module.mvp.MvpFragment;
import com.example.zerolab.Contract.StudentIndexContract;
import com.example.zerolab.R;
import com.example.zerolab.adapter.TechnicianLabAdapter;
import com.example.zerolab.bean.LabBean;
import com.example.zerolab.utils.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zero
 */
public class TechnicianIndexFragment extends MvpFragment<StudentIndexContract.StudentIndexPresenter> implements StudentIndexContract.IStudentIndex {
    private RecyclerView labRecycler;
    private List<LabBean> labBeanList=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.module_fragment_technician_index,container,false);

        labRecycler=view.findViewById(R.id.rv_labInformation_student);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        labRecycler.setLayoutManager(layoutManager);
        TechnicianLabAdapter labAdapter=new TechnicianLabAdapter(R.layout.module_recycler_item_technician_lab,labBeanList);
        labRecycler.setAdapter(labAdapter);

        return view;
    }

    @Override
    protected StudentIndexContract.StudentIndexPresenter createPresent() {
        return new StudentIndexContract.StudentIndexPresenter();
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        initList();
    }

    private void initList() {
        LabBean labBean1=new LabBean("光学实验室","这里是光学实验室","基础楼303","12:00-13:00","光学显微镜、放大器","已预约");
        labBeanList.add(labBean1);
        LabBean labBean2=new LabBean("化学实验室","这里是化学实验室","基础楼304","14:00-18:00","烧杯、量筒","未预约");
        labBeanList.add(labBean2);
        LabBean labBean3=new LabBean("物理实验室","这里是物理实验室","基础楼203","10:00-14:00","天平、砝码","未预约");
        labBeanList.add(labBean3);
        Log.d(Constant.TAG_D, "initList: ------------------> list size "+labBeanList.size());
    }
}
