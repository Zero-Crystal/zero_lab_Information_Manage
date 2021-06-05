package com.example.zerolab.fragment.technician;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.module.mvp.MvpFragment;
import com.example.zerolab.Contract.LabInformationContract;
import com.example.zerolab.R;
import com.example.zerolab.adapter.TechnicianLabAdapter;
import com.example.zerolab.bean.LabInformationBean;
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
public class TechnicianIndexFragment extends MvpFragment<LabInformationContract.LabInformationPresenter> implements LabInformationContract.ILabInformationVew {
    private RecyclerView labRecycler;
    private List<LabInformationBean.LabInformation.Labs> labBeanList=new ArrayList<>();
    private TechnicianLabAdapter labAdapter;

    private SmartRefreshLayout refreshLayout;

    @Override
    protected LabInformationContract.LabInformationPresenter createPresent() {
        return new LabInformationContract.LabInformationPresenter();
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        mPresent.LabInformation();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.module_fragment_technician_index,container,false);

        refreshLayout=view.findViewById(R.id.sr_tech_refresh);
        refreshLayout.setRefreshHeader(new WaveSwipeHeader(getContext()));
        refreshLayout.setEnableLoadMore(false);

        labRecycler=view.findViewById(R.id.rv_labInformation_student);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        labRecycler.setLayoutManager(layoutManager);
        labAdapter=new TechnicianLabAdapter(R.layout.module_recycler_item_technician_lab,labBeanList);
        labRecycler.setAdapter(labAdapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mPresent.LabInformation();;
                refreshLayout.finishRefresh();
            }
        });
    }

    @Override
    public void getLabInformation(Response<LabInformationBean> labInformationBeanResponse) {
        labBeanList.clear();
        labBeanList.addAll(labInformationBeanResponse.body().getLabInformation().getLabs());
        labAdapter.notifyDataSetChanged();
    }

    @Override
    public void Failed() {
        Toast.makeText(getContext(), "网络错误", LENGTH_SHORT).show();
    }
}
