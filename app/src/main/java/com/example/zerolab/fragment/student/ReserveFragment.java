package com.example.zerolab.fragment.student;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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

    private EditText etStudentName;
    private EditText etStudentNumber;
    private EditText etExperimentName;
    private EditText etStudentSum;
    private CheckBox cbIsChecked;
    private Button btnSubmit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.module_fragment_student_reserve, container, false);

        initData();
        initView(view);
        prepareSpinner(view);

        getEditText();

        //预约按钮点击提交事件
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
                Toast.makeText(view.getContext(),"您点击了预约提交按钮",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    /**
     * 获取editText等预约页面的内容，存入数据库，并申请预约，等待老师审批
     * */
    private void getEditText() {
        //TODO
    }

    /**
     * 填充：
     * 实验室spinner、实验室开放时间spinner、实验室关闭时间spinner
     * */
    private void prepareSpinner(View view) {
        //实验室选择spinner
        ArrayAdapter labChooseAdapter = new ArrayAdapter(view.getContext(), R.layout.module_spinner_item, labChooseList);
        spLabChoose.setAdapter(labChooseAdapter);
        labChooseAdapter.setDropDownViewResource(R.layout.module_spinner_item);
        //实验室开始时间
        ArrayAdapter openTimeAdapter = new ArrayAdapter(view.getContext(),R.layout.module_spinner_item, timeList);
        openTimeAdapter.setDropDownViewResource(R.layout.module_spinner_item);
        spOpenTime.setAdapter(openTimeAdapter);
        //实验室结束时间
        ArrayAdapter endTimeAdapter = new ArrayAdapter(view.getContext(), R.layout.module_spinner_item, timeList);
        endTimeAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spEndTime.setAdapter(endTimeAdapter);
    }

    private void initView(View view) {
        spLabChoose = view.findViewById(R.id.sp_lab_choose);
        spOpenTime = view.findViewById(R.id.sp_students_opentime);
        spEndTime = view.findViewById(R.id.sp_students_endtime);
        etStudentName=view.findViewById(R.id.et_student_name);
        etStudentNumber=view.findViewById(R.id.et_student_num);
        etExperimentName=view.findViewById(R.id.et_experiment_name);
        etStudentSum=view.findViewById(R.id.et_students_sum);
        cbIsChecked=view.findViewById(R.id.cb_students_isChecked);
        btnSubmit=view.findViewById(R.id.btn_student_reserve);
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
