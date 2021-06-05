package com.example.zerolab.fragment.student;

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
import androidx.viewpager2.widget.ViewPager2;

import com.example.module.mvp.MvpFragment;
import com.example.zerolab.Contract.LabQueryContract;
import com.example.zerolab.R;
import com.example.zerolab.activity.StudentActivity;
import com.example.zerolab.bean.LabBean;
import com.example.zerolab.bean.LabInformationBean;

import retrofit2.Response;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * @author zero
 */
public class StudentQueryFragment extends MvpFragment<LabQueryContract.LabQueryPresenter> implements LabQueryContract.ILabView {
    private EditText etLabName;
    private Button btnLabQuery;

    private CardView cvLabCard;
    private TextView tvLabName;
    private TextView tvLabIntroduction;
    private TextView tvLabAddress;
    private TextView tvLabOpenTime;
    private TextView tvLabEquip;
    private TextView tvLabReserve;
    private Button btnLabSubmit;

    private LabInformationBean.LabInformation.Labs labs=new LabInformationBean.LabInformation.Labs();

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
        btnLabSubmit=view.findViewById(R.id.btn_query_submit);

        //查询按钮点击事件
        btnLabQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击前设置实验室卡片不可见
                cvLabCard.setVisibility(View.GONE);
                //获取输入框输入的实验室名称
                String LabName=etLabName.getText().toString();
                //点击查询按钮，查询到的实验室信息
                mPresent.getLabQueryResult(LabName);
            }
        });

        //点击预约按钮进入预约页面
        btnLabSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final StudentActivity activity=(StudentActivity) getActivity();
                activity.setFragment(new StudentActivity.FragmentJump() {
                    @Override
                    public void goToFragment(ViewPager2 viewPager) {
                        activity.setLabInformationBean(labs);
                        viewPager.setCurrentItem(2);
                    }
                });
                activity.forSkip();
            }
        });

        return view;
    }

    @Override
    public void getLabQueryResult(Response<LabBean> response) {
        LabBean.LabParams lab=response.body().getLabParams();
        String result="Success";
        if(result.equals(lab.getResult())){
            labs.setLabName(lab.getLabName());
            labs.setLabIntroduce(lab.getLabIntroduce());
            labs.setLabAddress(lab.getLabAddress());
            labs.setLabEquip(lab.getLabEquip());
            labs.setLabOpenTime(lab.getLabOpenTime());
            labs.setLabReserve(lab.getLabReserve());

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
