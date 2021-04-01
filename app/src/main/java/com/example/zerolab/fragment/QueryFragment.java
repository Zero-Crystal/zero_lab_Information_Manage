package com.example.zerolab.fragment;

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
import androidx.fragment.app.Fragment;

import com.example.zerolab.R;

import org.w3c.dom.Text;

/**
 * @author zero
 */
public class QueryFragment extends Fragment {
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

    String LabName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.module_fragment_query,container,false);

        etLabName=view.findViewById(R.id.et_fragment_query);
        btnLabQuery=view.findViewById(R.id.btn_fragment_query);

        cvLabCard=view.findViewById(R.id.lab_cardView);
        tvLabName=view.findViewById(R.id.tv_item_title);
        tvLabIntroduction=view.findViewById(R.id.tv_item_introduction);
        tvLabAddress=view.findViewById(R.id.tv_item_address);
        tvLabOpenTime=view.findViewById(R.id.tv_item_openTime);
        tvLabEquip=view.findViewById(R.id.tv_item_equip);
        tvLabReserve=view.findViewById(R.id.tv_item_reserve);
        btnLabSubmit=view.findViewById(R.id.btn_item_submit);

        //查询前设置实验室卡片不可见
        cvLabCard.setVisibility(View.GONE);
        //获取输入框输入的实验室名称
        LabName=etLabName.getText().toString();

        //查询按钮点击事件
        btnLabQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击查询按钮，将查询到的实验室信息显示在下方卡片中
                Toast.makeText(view.getContext(),"您点击了查询按钮，为您查询该实验室",Toast.LENGTH_SHORT);
                cvLabCard.setVisibility(View.VISIBLE);
            }
        });

        return view;
    }
}
