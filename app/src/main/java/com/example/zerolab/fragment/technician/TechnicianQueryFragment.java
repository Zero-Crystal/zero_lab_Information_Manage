package com.example.zerolab.fragment.technician;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.example.module.mvp.MvpFragment;
import com.example.zerolab.Contract.LabQueryContract;
import com.example.zerolab.R;
import com.example.zerolab.bean.LabBean;

import retrofit2.Response;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * @author DELL
 */
public class TechnicianQueryFragment extends MvpFragment<LabQueryContract.LabQueryPresenter> implements LabQueryContract.ILabView {
    private EditText etLabName;
    private Button btnLabQuery;

    private CardView cvLabCard;
    private TextView tvLabName;
    private TextView tvLabIntroduction;
    private TextView tvLabAddress;
    private TextView tvLabOpenTime;
    private TextView tvLabEquip;
    private TextView tvLabReserve;

    @Override
    protected LabQueryContract.LabQueryPresenter createPresent() {
        return new LabQueryContract.LabQueryPresenter();
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.module_fragment_student_query,container,false);

        etLabName=view.findViewById(R.id.et_fragment_query);
        btnLabQuery=view.findViewById(R.id.btn_fragment_query);

        cvLabCard=view.findViewById(R.id.lab_query_cardView);
        tvLabName=view.findViewById(R.id.tv_query_title);
        tvLabIntroduction=view.findViewById(R.id.tv_query_introduction);
        tvLabAddress=view.findViewById(R.id.tv_query_address);
        tvLabOpenTime=view.findViewById(R.id.tv_query_openTime);
        tvLabEquip=view.findViewById(R.id.tv_query_equip);
        tvLabReserve=view.findViewById(R.id.tv_query_reserve);

        Button btnSubmit=view.findViewById(R.id.btn_query_submit);
        btnSubmit.setVisibility(View.GONE);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        //查询按钮点击事件
        btnLabQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取输入框输入的实验室名称
                String LabName=etLabName.getText().toString();
                //点击查询按钮，查询到的实验室信息
                mPresent.getLabQueryResult(LabName);
            }
        });
    }

    @Override
    public void getLabQueryResult(Response<LabBean> response) {
        LabBean.LabParams lab=response.body().getLabParams();
        String result="Success";
        if(result.equals(lab.getResult())){
            tvLabName.setText(lab.getLabName());
            tvLabIntroduction.setText(lab.getLabIntroduce());
            tvLabAddress.setText(lab.getLabAddress());
            tvLabOpenTime.setText(lab.getLabOpenTime());
            tvLabEquip.setText(lab.getLabEquip());
            tvLabReserve.setText(lab.getLabReserve());

            cvLabCard.setVisibility(View.VISIBLE);
        }else {
            Toast.makeText(getContext(), lab.getResult(), LENGTH_SHORT).show();
        }
    }

    @Override
    public void getFailed() {
        Toast.makeText(getContext(), "网络错误", LENGTH_SHORT).show();
    }
}
