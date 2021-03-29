package com.example.zerolab.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.zerolab.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zero
 */
public class ReserveFragment extends Fragment {
    private final List<String> labChooseList = new ArrayList<>();
    private Spinner spLabChoose;

    private List<String> timeList = new ArrayList<>();
    private Spinner spOpenTime;
    private Spinner spEndTime;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.module_fragment_student_reserve, container, false);
        initData();
        //实验室选择spinner
        spLabChoose = view.findViewById(R.id.sp_lab_choose);
        ArrayAdapter labChooseAdapter = new ArrayAdapter(view.getContext(), R.layout.module_spinner_item, labChooseList);
        spLabChoose.setAdapter(labChooseAdapter);
        labChooseAdapter.setDropDownViewResource(R.layout.module_spinner_item);
        //实验室开始时间
        spOpenTime = view.findViewById(R.id.sp_students_opentime);
        ArrayAdapter openTimeAdapter = new ArrayAdapter(view.getContext(),R.layout.module_spinner_item, timeList);
        openTimeAdapter.setDropDownViewResource(R.layout.module_spinner_item);
        spOpenTime.setAdapter(openTimeAdapter);
        //实验室结束时间
        spEndTime = view.findViewById(R.id.sp_students_endtime);
        ArrayAdapter endTimeAdapter = new ArrayAdapter(view.getContext(), R.layout.module_spinner_item, timeList);
        endTimeAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spEndTime.setAdapter(endTimeAdapter);

        return view;
    }

    public void initData() {
        //初始化实验室List
        labChooseList.add("请选择实验室");
        labChooseList.add("光学实验室");
        labChooseList.add("物理实验室");
        labChooseList.add("化学实验室");
        //初始化开始时间List
        timeList.add("0:00");
        timeList.add("1:00");
        timeList.add("2:00");
        timeList.add("3:00");
        timeList.add("4:00");
        timeList.add("5:00");
        timeList.add("6:00");
        timeList.add("7:00");
    }
}
