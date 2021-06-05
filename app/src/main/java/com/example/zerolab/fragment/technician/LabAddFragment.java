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
import com.example.zerolab.Contract.LabAddContract;
import com.example.zerolab.R;
import com.example.zerolab.bean.LabInsertResponseBean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Response;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * @author DELL
 */
public class LabAddFragment extends MvpFragment<LabAddContract.LabAddPresenter> implements LabAddContract.ILabAddView {
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
    protected LabAddContract.LabAddPresenter createPresent() {
        return new LabAddContract.LabAddPresenter();
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.module_fragment_technician_lab_add, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        etLabNum = view.findViewById(R.id.et_lab_num);
        etLabAddress = view.findViewById(R.id.et_lab_address);
        etLabName = view.findViewById(R.id.et_lab_name);
        etLabIntroduce = view.findViewById(R.id.et_lab_introduce);
        etLabEquip = view.findViewById(R.id.et_lab_equip);
        etLabSum = view.findViewById(R.id.et_lab_sum);
        cbLabChecked = view.findViewById(R.id.cb_lab_isChecked);
        btnLabOpenTime = view.findViewById(R.id.btn_lab_open_time);
        btnLabEndTime = view.findViewById(R.id.btn_lab_end_time);
        btTechnicianSubmit = view.findViewById(R.id.btn_technician_submit);
    }

    @Override
    public void onResume() {
        super.onResume();
        click();
    }

    private void click() {
        List<String> openTime = new ArrayList<>();
        List<String> endTime = new ArrayList<>();

        btnLabOpenTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), AlertDialog.THEME_HOLO_LIGHT, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        //TODO
                        openTime.add(String.valueOf(hourOfDay));
                        openTime.add(String.valueOf(minute));
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
                        endTime.add(String.valueOf(hourOfDay));
                        endTime.add(String.valueOf(minute));
                        btnLabEndTime.setText(hourOfDay + " : " + minute);
                    }
                }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
                timePickerDialog.show();
            }
        });

        cbLabChecked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cbLabChecked.isChecked()) {
                    btTechnicianSubmit.setEnabled(true);
                }
            }
        });

        //提交按钮点击事件
        btTechnicianSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
                String labTime = null;
                String labNum = etLabNum.getText().toString();
                String labName = etLabName.getText().toString();
                String labAddress = etLabAddress.getText().toString();
                String labIntroduce = etLabIntroduce.getText().toString();
                String labSum = etLabSum.getText().toString();
                String labEquip = etLabEquip.getText().toString();
                if (labNum.isEmpty() || labName.isEmpty() || labAddress.isEmpty() || labIntroduce.isEmpty() || labSum.isEmpty() || labEquip.isEmpty()){
                    Toast.makeText(getContext(), "请您完整填写实验室信息表！", Toast.LENGTH_SHORT).show();
                }else{
                    if (openTime.size() > 0 && endTime.size() > 0) {
                        labTime = openTime.get(0) + ":" + openTime.get(1) + " - " + endTime.get(0) + ":" + endTime.get(1);
                    } else {
                        Toast.makeText(getContext(), "请您选择实验室开放时间！", Toast.LENGTH_SHORT).show();
                    }
                    mPresent.insetLabInformation(labNum, labName, labAddress, labIntroduce, labSum, labEquip, labTime);
                }
            }
        });
    }

    @Override
    public void getLabInsertResult(Response<LabInsertResponseBean> response) {
        if(response.body().getLabParams()!=null){
            Toast.makeText(getContext(), "恭喜您提交成功！", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void getFailed() {
        Toast.makeText(getContext(), "网络错误", LENGTH_SHORT).show();
    }
}
