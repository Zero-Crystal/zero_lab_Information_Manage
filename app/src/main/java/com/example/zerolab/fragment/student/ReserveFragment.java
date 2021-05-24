package com.example.zerolab.fragment.student;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.module.mvp.MvpFragment;
import com.example.zerolab.Contract.StudentIndexContract;
import com.example.zerolab.R;
import com.example.zerolab.utils.Constant;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author zero
 */
public class ReserveFragment extends MvpFragment<StudentIndexContract.StudentIndexPresenter> implements StudentIndexContract.IStudentIndex {
    private final List<String> labChooseList = new ArrayList<>();
    private Spinner spLabChoose;
    private String labChoose;

    private EditText etStudentName;
    private EditText etStudentNumber;
    private EditText etExperimentName;
    private EditText etStudentSum;
    private CheckBox cbIsChecked;
    private Button btnSubmit;
    private Button btnTpOpenTime;
    private Button btnTpEndTime;

    @Override
    protected StudentIndexContract.StudentIndexPresenter createPresent() {
        return new StudentIndexContract.StudentIndexPresenter();
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.module_fragment_student_reserve, container, false);
        initView(view);
        prepareSpinner();

        click(view);
        return view;
    }

    private void click(View view) {
        spLabChoose.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                labChoose = labChooseList.get(position);
                Log.d(Constant.TAG_D, "onItemClick: --------------------------> "+labChoose);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnTpOpenTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), AlertDialog.THEME_HOLO_LIGHT, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        //TODO
                        btnTpOpenTime.setText(hourOfDay + " : " + minute);
                    }
                }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
                timePickerDialog.show();
            }
        });

        btnTpEndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), AlertDialog.THEME_HOLO_LIGHT, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        //TODO
                        btnTpEndTime.setText(hourOfDay + " : " + minute);
                    }
                }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
                timePickerDialog.show();
            }
        });

        //预约按钮点击提交事件
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
                Toast.makeText(view.getContext(), "您点击了预约提交按钮", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView(View view) {
        spLabChoose = view.findViewById(R.id.sp_lab_choose);
        btnTpOpenTime = view.findViewById(R.id.btn_students_open_time);
        btnTpEndTime = view.findViewById(R.id.btn_students_end_time);
        etStudentName = view.findViewById(R.id.et_student_name);
        etStudentNumber = view.findViewById(R.id.et_student_num);
        etExperimentName = view.findViewById(R.id.et_experiment_name);
        etStudentSum = view.findViewById(R.id.et_students_sum);
        cbIsChecked = view.findViewById(R.id.cb_students_isChecked);
        btnSubmit = view.findViewById(R.id.btn_student_reserve);
    }

    /**
     * 填充：
     * 实验室spinner、实验室开放时间spinner、实验室关闭时间spinner
     */
    private void prepareSpinner() {
        //初始化实验室List
        labChooseList.add("请选择实验室");
        labChooseList.add("光学实验室");
        labChooseList.add("物理实验室");
        labChooseList.add("化学实验室");
        //实验室选择spinner
        ArrayAdapter labChooseAdapter = new ArrayAdapter(getContext(), R.layout.module_spinner_lab_choose_item, labChooseList);
        labChooseAdapter.setDropDownViewResource(R.layout.module_spinner_lab_choose_item);
        spLabChoose.setAdapter(labChooseAdapter);
    }

}
