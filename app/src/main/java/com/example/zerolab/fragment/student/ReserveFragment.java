package com.example.zerolab.fragment.student;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
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
import androidx.viewpager2.widget.ViewPager2;

import com.example.module.mvp.MvpFragment;
import com.example.zerolab.Contract.ReserveContract;
import com.example.zerolab.R;
import com.example.zerolab.activity.StudentActivity;
import com.example.zerolab.bean.LabInformationBean;
import com.example.zerolab.bean.ResultBean;
import com.example.zerolab.bean.UserManage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Response;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * @author zero
 */
public class ReserveFragment extends MvpFragment<ReserveContract.ReservePresenter> implements ReserveContract.IReserveView {
    private EditText etLabName;
    private EditText etStudentName;
    private EditText etStudentNumber;
    private EditText etExperimentName;
    private EditText etStudentSum;
    private CheckBox cbIsChecked;
    private Button btnSubmit;
    private Button btnTpOpenTime;
    private Button btnTpEndTime;

    private String stuName;
    private String stuNum;
    private String labName;
    private String experimentName;
    private String studentSum;
    private String experimentTime;
    private LabInformationBean.LabInformation.Labs lab = new LabInformationBean.LabInformation.Labs();

    @Override
    protected ReserveContract.ReservePresenter createPresent() {
        return new ReserveContract.ReservePresenter();
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        Log.d("TAG_ZERO", "initData: ---------------->ReserveFragment");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.module_fragment_student_reserve, container, false);
        Log.d("TAG_ZERO", "onCreateView: ---------------->ReserveFragment");
        initView(view);
        return view;
    }

    public void initView(View view) {
        btnTpOpenTime = view.findViewById(R.id.btn_students_open_time);
        btnTpEndTime = view.findViewById(R.id.btn_students_end_time);
        etLabName = view.findViewById(R.id.etLabName);
        etStudentName = view.findViewById(R.id.et_student_name);
        etStudentNumber = view.findViewById(R.id.et_student_num);
        etExperimentName = view.findViewById(R.id.et_experiment_name);
        etStudentSum = view.findViewById(R.id.et_students_sum);
        cbIsChecked = view.findViewById(R.id.cb_students_isChecked);
        btnSubmit = view.findViewById(R.id.btn_student_reserve);

        btnSubmit.setEnabled(false);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("TAG_ZERO", "initData: ------------->" + lab.getLabName());

        lab = ((StudentActivity) getActivity()).getLabInformationBean();
        etLabName.setText(lab.getLabName());
        etStudentName.setText(UserManage.getInstance().getUserName());
        etStudentNumber.setText(UserManage.getInstance().getUserNum());

        click();
    }

    public void click() {
        List<String> openTime = new ArrayList<>();
        List<String> endTime = new ArrayList<>();
        //选择实验开始时间
        btnTpOpenTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), AlertDialog.THEME_HOLO_LIGHT, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        //TODO
                        openTime.add(String.valueOf(hourOfDay));
                        openTime.add(String.valueOf(minute));
                        btnTpOpenTime.setText(hourOfDay + " : " + minute);
                    }
                }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
                timePickerDialog.show();
            }
        });
        //选择实验结束时间
        btnTpEndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), AlertDialog.THEME_HOLO_LIGHT, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        //TODO
                        endTime.add(String.valueOf(hourOfDay));
                        endTime.add(String.valueOf(minute));
                        btnTpEndTime.setText(hourOfDay + " : " + minute);
                    }
                }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
                timePickerDialog.show();
            }
        });

        cbIsChecked.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cbIsChecked.isChecked()){
                    btnSubmit.setEnabled(true);
                }else{
                    btnSubmit.setEnabled(false);
                }
            }
        });
        //预约按钮点击提交事件
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
                labName = etLabName.getText().toString();
                stuName = etStudentName.getText().toString();
                stuNum = etStudentNumber.getText().toString();
                experimentName = etExperimentName.getText().toString();
                studentSum = etStudentSum.getText().toString();
                experimentTime = openTime.get(0) + ":" + openTime.get(1) + "-" + endTime.get(0) + ":" + endTime.get(1);

                if(labName.isEmpty()||stuNum.isEmpty()||stuName.isEmpty()||experimentName.isEmpty()||studentSum.isEmpty()||experimentTime.isEmpty()){
                    Toast.makeText(getContext(), "请您完整填写预约信息表！", Toast.LENGTH_SHORT).show();
                }else{
                    if (openTime.size() > 0 && endTime.size() > 0) {
                        experimentTime = openTime.get(0) + ":" + openTime.get(1) + " - " + endTime.get(0) + ":" + endTime.get(1);
                        mPresent.insertReserve(stuName, stuNum, labName, experimentName, studentSum, experimentTime);
                    } else {
                        Toast.makeText(getContext(), "请您选择实验进行的时间！", Toast.LENGTH_SHORT).show();
                    }
                }

                //跳转至预约结果页面
                Log.d("TAG_ZERO", "btnSubmit.setOnClickListener: ---------------->ReserveFragment");
                final StudentActivity activity = (StudentActivity) getActivity();
                activity.setFragment(new StudentActivity.FragmentJump() {
                    @Override
                    public void goToFragment(ViewPager2 viewPager) {
                        viewPager.setCurrentItem(3);
                    }
                });
                activity.forSkip();
            }
        });
    }

    @Override
    public void getReserveResult(Response<ResultBean> response) {
        Log.d("TAG_ZERO", "getReserveResult: ---------------->ReserveFragment");
    }

    @Override
    public void Failed() {
        Toast.makeText(getContext(), "网络错误", LENGTH_SHORT).show();
    }
}
