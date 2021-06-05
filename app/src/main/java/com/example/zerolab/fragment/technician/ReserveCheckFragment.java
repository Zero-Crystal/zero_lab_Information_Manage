package com.example.zerolab.fragment.technician;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.module.mvp.MvpFragment;
import com.example.zerolab.Contract.LabReserveCheckContract;
import com.example.zerolab.R;
import com.example.zerolab.adapter.ReserveCheckAdapter;
import com.example.zerolab.bean.ReserveCheckBean;
import com.example.zerolab.bean.ResultCheckResponseBean;
import com.example.zerolab.bean.UserManage;
import com.scwang.smartrefresh.header.WaveSwipeHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * @author zero
 */
public class ReserveCheckFragment extends MvpFragment<LabReserveCheckContract.LabReservePresenter> implements LabReserveCheckContract.ILabReserveCheckView {
    private RecyclerView rvReserveCheck;
    private ReserveCheckAdapter checkAdapter;
    private List<ReserveCheckBean.Results.ResultList> checkBeanList = new ArrayList<>();

    private SmartRefreshLayout refreshLayout;

    @Override
    protected LabReserveCheckContract.LabReservePresenter createPresent() {
        return new LabReserveCheckContract.LabReservePresenter();
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.module_fragment_technician_reserve_check, container, false);

        mPresent.getReserveCheckList();

        refreshLayout=view.findViewById(R.id.sr_tech_refresh);
        refreshLayout.setRefreshHeader(new WaveSwipeHeader(getContext()));
        refreshLayout.setEnableLoadMore(false);

        rvReserveCheck = view.findViewById(R.id.rv_technician_reserve_check);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        rvReserveCheck.setLayoutManager(layoutManager);
        checkAdapter = new ReserveCheckAdapter(R.layout.module_recycler_item_reserve_check, checkBeanList);
        rvReserveCheck.setAdapter(checkAdapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mPresent.getReserveCheckList();
                refreshLayout.finishRefresh();
            }
        });

        checkAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                String stuName=checkBeanList.get(position).getStuName();
                String experimentName=checkBeanList.get(position).getExperimentName();
                String checkResult;
                String checkTeacher= UserManage.getInstance().getUserName();
                switch (view.getId()) {
                    case R.id.btn_item_agree:
                        //TODO
                        checkBeanList.remove(position);
                        checkAdapter.notifyItemRemoved(position);//刷新被删除的地方
                        checkAdapter.notifyItemRangeChanged(position,checkAdapter.getItemCount());

                        checkResult="通过";
                        mPresent.editReserveCheck(stuName,experimentName,checkResult,checkTeacher);
                        Toast.makeText(getContext(), "通过预约", Toast.LENGTH_SHORT).show();
                        Log.d("TAG_ZERO", "checkAdapter: --------------->edit通过");
                        break;
                    case R.id.btn_item_cancel:
                        //TODO
                        checkBeanList.remove(position);
                        checkAdapter.notifyItemRemoved(position);//刷新被删除的地方
                        checkAdapter.notifyItemRangeChanged(position,checkAdapter.getItemCount());

                        checkResult="未通过";
                        mPresent.editReserveCheck(stuName,experimentName,checkResult,checkTeacher);
                        Toast.makeText(getContext(), "取消预约", Toast.LENGTH_SHORT).show();
                        Log.d("TAG_ZERO", "checkAdapter: --------------->edit取消");
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public void getReserveCheckList(Response<ReserveCheckBean> response) {
        checkBeanList.clear();
        checkBeanList.addAll(response.body().getResults().getResultList());
        checkAdapter.notifyDataSetChanged();
    }

    @Override
    public void getCheckResult(Response<ResultCheckResponseBean> response) {
        if(response.body()!=null){
            Log.d("TAG_ZERO", "getCheckResult: --------------->"+response.body().getResult().getCheckResult());
        }else {
            Log.d("TAG_ZERO", "getCheckResult: --------------->返回空");
        }
    }

    @Override
    public void getFailed() {
        Log.d("TAG_ZERO", "getFailed: --------------->网络错误");
        Toast.makeText(getContext(), "网络错误", LENGTH_SHORT).show();
    }
}
