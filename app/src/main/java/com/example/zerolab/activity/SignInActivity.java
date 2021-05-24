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

import androidx.appcompat.app.AppCompatActivity;

import com.example.zerolab.R;
import com.example.zerolab.utils.Constant;
import com.example.zerolab.utils.SpUtils;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * @author zero
 */
public class SignInActivity extends AppCompatActivity {
    private List<String> statusList = new ArrayList<>();
    private Spinner spStatus;


    private EditText etNumber;
    private EditText etPassword;
    private Button btnSignIn;

    String status;
    String status1="学生";
    String status2="实验员";
    String signNumber;
    String signPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_activity_signin);

        etNumber=findViewById(R.id.et_sign_number);
        etPassword=findViewById(R.id.et_sign_password);
        btnSignIn=findViewById(R.id.btn_sign_in);
        spStatus = findViewById(R.id.sp_sign_identify);

        initDate();

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
                Log.d(Constant.TAG_D, "onItemClick: --------------------------> "+status);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //登录按钮的点击监听
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //向SharedPreference中存储账号和密码
                StorageNumAndPassword();
                //获取身份信息并进入相应界面
                if(status.equals(status1)){
                    Intent intent1=new Intent(SignInActivity.this, StudentActivity.class);
                    startActivity(intent1);
                }else if(status.equals(status2)){
                    Intent intent2=new Intent(SignInActivity.this, LabTechnicianActivity.class);
                    startActivity(intent2);
                }else {
                    Toast.makeText(SignInActivity.this,"请选择您的身份后再进行登录", LENGTH_SHORT).show();
                }
            }
        });
    }

    private void StorageNumAndPassword() {
        SpUtils.putString(SignInActivity.this,"number",signNumber);
        SpUtils.putString(SignInActivity.this,"password",signPassword);
    }

    private void initDate() {
        statusList.add("请选择你的身份");
        statusList.add("学生");
        statusList.add("实验员");

        signNumber=etNumber.getText().toString();
        signPassword=etPassword.getText().toString();
    }
}