package com.example.zerolab.fragment.student;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.zerolab.R;
import com.example.zerolab.adapter.ReserveResultAdapter;
import com.example.zerolab.bean.ReserveResultBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zero
 */
public class ReserveResultFragment extends Fragment {
    private RecyclerView resultRecycler;
    private List<ReserveResultBean> resultBeanList = new ArrayList<>();
    private final int btnCancel=R.id.btn_item_cancel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.module_fragment_student_result, container, false);

        initView(view);
        initData();
        ReserveResultAdapter resultAdapter=new ReserveResultAdapter(R.layout.module_recycler_item_reserve_result,resultBeanList);
        LinearLayoutManager layoutManager=new LinearLayoutManager(view.getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        resultRecycler.setLayoutManager(layoutManager);
        resultRecycler.setAdapter(resultAdapter);

        resultAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                //获取item对象
                ReserveResultBean resultBean= (ReserveResultBean) adapter.getItem(position);
                //TODO
                switch (view.getId()){
                    case btnCancel:
                        Toast.makeText(getContext(),"取消预约",Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });

        return view;
    }

    private void initData() {
        ReserveResultBean result1=new ReserveResultBean("光学实验室","小孔成像","13:00","14:00","未通过","王老师");
        resultBeanList.add(result1);
        ReserveResultBean result2=new ReserveResultBean("化学实验室","制造氧气","14:30","16:30","已通过","王老师");
        resultBeanList.add(result2);
    }

    private void initView(View view) {
        resultRecycler = view.findViewById(R.id.rv_reserveResult_student);
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
