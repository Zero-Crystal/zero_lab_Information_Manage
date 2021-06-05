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
import androidx.viewpager2.widget.ViewPager2;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.module.mvp.MvpFragment;
import com.example.zerolab.Contract.LabInformationContract;
import com.example.zerolab.R;
import com.example.zerolab.activity.StudentActivity;
import com.example.zerolab.adapter.LabInformationAdapter;
import com.example.zerolab.bean.LabInformationBean;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * @author zero
 */
public class IndexFragment extends MvpFragment<LabInformationContract.LabInformationPresenter> implements LabInformationContract.ILabInformationVew {
    private RecyclerView labRecycler;
    private List<LabInformationBean.LabInformation.Labs> labBeanList = new ArrayList<>();
    private LabInformationAdapter labAdapter;

    @Override
    protected LabInformationContract.LabInformationPresenter createPresent() {
        return new LabInformationContract.LabInformationPresenter();
    }

    @Override
    public void initData(Bundle savedInstanceState) {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("TAG", "onCreateView: ------------------> 已执行");
        View view = inflater.inflate(R.layout.module_fragment_student_index, container, false);

        mPresent.LabInformation();

        labRecycler = view.findViewById(R.id.rv_labInformation_student);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        labRecycler.setLayoutManager(layoutManager);
        labAdapter = new LabInformationAdapter(R.layout.module_recycler_item_lab, labBeanList);
        labRecycler.setAdapter(labAdapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        //RecyclerView内部按钮点击事件：获取该item预约信息，并跳转预约页面
        labAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                final StudentActivity studentActivity=(StudentActivity) getActivity();
                studentActivity.setFragment(new StudentActivity.FragmentJump() {
                    @Override
                    public void goToFragment(ViewPager2 viewPager) {
                        studentActivity.setLabInformationBean(labBeanList.get(position));
                        viewPager.setCurrentItem(2);
                    }
                });
                studentActivity.forSkip();
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