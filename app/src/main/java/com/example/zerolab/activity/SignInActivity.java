package com.example.zerolab.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.module.mvp.MvpActivity;
import com.example.zerolab.Contract.LogInContract;
import com.example.zerolab.R;
import com.example.zerolab.bean.LoginUserBean;
import com.example.zerolab.bean.UserManage;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * @author zero
 */
public class SignInActivity extends MvpActivity<LogInContract.LogInPresenter> implements LogInContract.ILogInVew {
    private List<String> statusList = new ArrayList<>();
    private Spinner spStatus;

    private EditText etNumber;
    private EditText etPassword;
    private Button btnSignIn;

    /**
     * @param status: 用户选择的登录身份
     * @param status1: 学生身份
     * @param status2: 实验员身份
     * @param signNumber: 登录账号
     * @param signNumber: 登录密码
     */
    private String status;
    private final String student="学生";
    private final String technician="实验员";

    @Override
    protected LogInContract.LogInPresenter createPresent() {
        return new LogInContract.LogInPresenter();
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        statusList.add("请选择您的身份");
        statusList.add("学生");
        statusList.add("实验员");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_activity_signin);

        etNumber = findViewById(R.id.et_sign_number);
        etPassword = findViewById(R.id.et_sign_password);
        btnSignIn = findViewById(R.id.btn_sign_in);
        spStatus = findViewById(R.id.sp_sign_identify);

        ArrayAdapter spAdapter = new ArrayAdapter(this, R.layout.module_spinner_item, statusList);
        spAdapter.setDropDownViewResource(R.layout.module_spinner_item);
        spStatus.setAdapter(spAdapter);

        onClick();
    }

    private void onClick() {
        //身份spinner选择状态的监听
        spStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                status = statusList.get(position);
                Log.d("TAG", "onItemClick: --------------------------> " + status);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //登录按钮的点击监听
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG", "onClick: -------------->this is btn click");
                String userNum = etNumber.getText().toString();
                String userPassword = etPassword.getText().toString();
                mPresent.getLogInStatus(userNum, userPassword,status);
            }
        });
    }

    /**
     * 将登录者账户信息封装
     *
     * @return user
     */
    @Override
    public void getLoginInformation(Response<LoginUserBean> response) {
        String result = response.body().getUser().getResult();
        String success = "success";
        String userStatus=response.body().getUser().getUserStatus();
        if (success.equals(result)) {
            UserManage.getInstance().setUserNum(response.body().getUser().getUserNum());
            UserManage.getInstance().setUserName(response.body().getUser().getUserName());
            if(student.equals(userStatus)){
                Intent intent1 = new Intent(SignInActivity.this, StudentActivity.class);
                startActivity(intent1);
            }else if(technician.equals(userStatus)){
                Intent intent2=new Intent(SignInActivity.this, LabTechnicianActivity.class);
                startActivity(intent2);
            }
        } else {
            Toast.makeText(SignInActivity.this, "您输入的账户有误 " + result, LENGTH_SHORT).show();
        }
    }

    @Override
    public void getFailed() {
        Toast.makeText(SignInActivity.this, "网络错误", LENGTH_SHORT).show();
    }
}