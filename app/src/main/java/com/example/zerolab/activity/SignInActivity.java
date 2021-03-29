package com.example.zerolab.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.zerolab.R;
import com.example.zerolab.adapter.LabInformationAdapter;
import com.example.zerolab.utils.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zero
 */
public class SignInActivity extends AppCompatActivity {
    private List<String> statusList = new ArrayList<>();
    private Spinner spStatus;
    private Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_activity_signin);

        initDate();

        btnSignIn=findViewById(R.id.btn_sign_in);

        spStatus = findViewById(R.id.sp_sign_identify);
        ArrayAdapter spAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, statusList);
        spAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spStatus.setAdapter(spAdapter);
        spStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String status = statusList.get(position);
                String status1="学生";
                String status2="实验员";
                Log.d(Constant.TAG_D, "onItemClick: --------------------------> "+status);
                if(status.equals(status1)){
                    Intent intent1=new Intent(SignInActivity.this,StudentActivity.class);
                    startActivity(intent1);
                }else if(status.equals(status2)){
                    Intent intent2=new Intent(SignInActivity.this, LabTechnicianActivity.class);
                    startActivity(intent2);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void initDate() {
        statusList.add("请选择你的身份");
        statusList.add("学生");
        statusList.add("实验员");
    }
}