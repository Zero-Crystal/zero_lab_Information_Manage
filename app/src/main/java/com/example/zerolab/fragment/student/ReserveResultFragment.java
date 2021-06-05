package com.example.zerolab.fragment.student;

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

import com.example.module.mvp.MvpFragment;
import com.example.zerolab.Contract.ResultContract;
import com.example.zerolab.R;
import com.example.zerolab.adapter.ReserveResultAdapter;
import com.example.zerolab.bean.ReserveResultBean;
import com.example.zerolab.bean.ResultBean;
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
public class ReserveResultFragment extends MvpFragment<ResultContract.ResultPresenter> implements ResultContract.IResultView {
    private RecyclerView resultRecycler;
    private List<ReserveResultBean.Results.Result> resultBeanList = new ArrayList<>();
    private ResultBean.Params resultBean;
    private ReserveResultAdapter resultAdapter;
    private SmartRefreshLayout refreshLayout;

    @Override
    protected ResultContract.ResultPresenter createPresent() {
        return new ResultContract.ResultPresenter();
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        Log.d("TAG1", "initData: ----------------->ReserveResultFragment UserNum "+UserManage.getInstance().getUserNum());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.module_fragment_student_result, container, false);

        mPresent.getReserveResult(UserManage.getInstance().getUserNum());

        resultRecycler = view.findViewById(R.id.rv_reserveResult_student);
        resultAdapter=new ReserveResultAdapter(R.layout.module_recycler_item_reserve_result,resultBeanList);
        LinearLayoutManager layoutManager=new LinearLayoutManager(view.getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        resultRecycler.setLayoutManager(layoutManager);
        resultRecycler.setAdapter(resultAdapter);
        refreshLayout=view.findViewById(R.id.sr_refresh);
        refreshLayout.setRefreshHeader(new WaveSwipeHeader(getContext()));
        refreshLayout.setEnableLoadMore(false);

        Log.d("TAG1", "onCreateView: ---------------->ReserveResultFragment");

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("TAG1", "onResume: ----------->ReserveResultFragment");
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mPresent.getReserveResult(UserManage.getInstance().getUserNum());
                refreshLayout.finishRefresh();
            }
        });
    }

    @Override
    public void getReserveResult(Response<ReserveResultBean> response) {
        resultBeanList.clear();
        resultBeanList.addAll(response.body().getResult().getResults());
        resultAdapter.notifyDataSetChanged();
    }

    @Override
    public void getFailed() {
        Toast.makeText(getContext(), "网络错误", LENGTH_SHORT).show();
    }
}
