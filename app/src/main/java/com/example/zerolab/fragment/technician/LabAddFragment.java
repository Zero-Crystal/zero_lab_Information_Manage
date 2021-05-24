package com.example.zerolab.fragment.technician;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.module.mvp.MvpFragment;
import com.example.zerolab.Contract.StudentIndexContract;
import com.example.zerolab.R;

import java.util.Calendar;

/**
 * @author DELL
 */
public class LabAddFragment extends MvpFragment<StudentIndexContract.StudentIndexPresenter> implements StudentIndexContract.IStudentIndex {
    private EditText etLabNum;
    private EditText etLabAddress;
    private EditText etLabName;
    private EditText etLabSum;
    private EditText etLabIntroduce;
    private EditText etLabEquip;
    private CheckBox cbLabChecked;
    private Button btTechnicianSubmit;
    private Button btnLabOpenTime;
    private Button btnLabEndTime;

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
        View view = inflater.inflate(R.layout.module_fragment_technician_lab_add, container, false);
        initView(view);

        click(view);
        return view;
    }

    private void click(View view) {
        btnLabOpenTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), AlertDialog.THEME_HOLO_LIGHT, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        //TODO
                        btnLabOpenTime.setText(hourOfDay + " : " + minute);
                    }
                }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
                timePickerDialog.show();
            }
        });

        btnLabEndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), AlertDialog.THEME_HOLO_LIGHT, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        //TODO
                        btnLabEndTime.setText(hourOfDay + " : " + minute);
                    }
                }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
                timePickerDialog.show();
            }
        });

        //提交按钮点击事件
        btTechnicianSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
                Toast.makeText(view.getContext(),"您点击了提交按钮",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView(View view) {
        etLabNum = view.findViewById(R.id.et_lab_num);
        etLabAddress = view.findViewById(R.id.et_lab_address);
        etLabName = view.findViewById(R.id.et_lab_name);
        etLabIntroduce = view.findViewById(R.id.et_lab_introduce);
        etLabEquip = view.findViewById(R.id.et_lab_equip);
        etLabSum = view.findViewById(R.id.et_lab_sum);
        cbLabChecked = view.findViewById(R.id.cb_students_isChecked);
        btnLabOpenTime=view.findViewById(R.id.btn_lab_open_time);
        btnLabEndTime=view.findViewById(R.id.btn_lab_end_time);
        btTechnicianSubmit = view.findViewById(R.id.btn_technician_submit);
    }
}
