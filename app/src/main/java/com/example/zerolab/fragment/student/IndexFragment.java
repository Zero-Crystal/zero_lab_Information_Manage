package com.example.zerolab.fragment.student;

import android.os.Bundle;
import android.util.Log;
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
import com.example.zerolab.adapter.LabInformationAdapter;
import com.example.zerolab.bean.LabBean;
import com.example.zerolab.utils.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zero
 */
public class IndexFragment extends MvpFragment<StudentIndexContract.StudentIndexPresenter> implements StudentIndexContract.IStudentIndex {
    private RecyclerView labRecycler;
    private List<LabBean> labBeanList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(Constant.TAG_D, "onCreateView: ------------------> 已执行");
        View view = inflater.inflate(R.layout.module_fragment_student_index, container, false);

        labRecycler = view.findViewById(R.id.rv_labInformation_student);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        labRecycler.setLayoutManager(layoutManager);
        LabInformationAdapter labAdapter = new LabInformationAdapter(R.layout.module_recycler_item_lab, labBeanList);
        labRecycler.setAdapter(labAdapter);
        //RecyclerView内部按钮点击事件：获取该item预约信息，并跳转预约页面
        labAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                //Click Test
                LabBean labBean = (LabBean) adapter.getItem(position);
                Toast.makeText(view.getContext(), labBean.getLabName() + " 地址：" + labBean.getLabAddress() + " " + position, Toast.LENGTH_LONG).show();
                //TODO
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
        initList();
    }

    private void initList() {
        LabBean labBean1 = new LabBean("光学实验室", "这里是光学实验室", "基础楼303", "12:00-13:00", "光学显微镜、放大器", "已预约");
        labBeanList.add(labBean1);
        LabBean labBean2 = new LabBean("化学实验室", "这里是化学实验室", "基础楼304", "14:00-18:00", "烧杯、量筒", "未预约");
        labBeanList.add(labBean2);
        LabBean labBean3 = new LabBean("物理实验室", "这里是物理实验室", "基础楼203", "10:00-14:00", "天平、砝码", "未预约");
        labBeanList.add(labBean3);
        Log.d(Constant.TAG_D, "initList: ------------------> list size " + labBeanList.size());
    }

}