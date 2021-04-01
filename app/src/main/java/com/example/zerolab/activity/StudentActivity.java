package com.example.zerolab.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;

import com.example.zerolab.R;
import com.example.zerolab.adapter.TabAdapter;
import com.example.zerolab.fragment.student.IndexFragment;
import com.example.zerolab.fragment.QueryFragment;
import com.example.zerolab.fragment.student.ReserveFragment;
import com.example.zerolab.fragment.student.ReserveResultFragment;
import com.example.zerolab.utils.Constant;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zero
 */
public class StudentActivity extends AppCompatActivity {
    private TabLayout tl_student;
    private ViewPager2 vp_student;
    private List<String> title = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_activity_student);
        initDate();
        //实例化适配器
        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager(), getLifecycle(), fragmentList);
        //设置适配器
        vp_student.setAdapter(tabAdapter);
        //将tabLayout与viewpager关联
        new TabLayoutMediator(tl_student, vp_student, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(title.get(position));
            }
        }).attach();
    }

    public void initDate() {
        tl_student = findViewById(R.id.tl_student);
        vp_student = findViewById(R.id.vp_student);

        title.add("首页");
        title.add("查询");
        title.add("预约");
        title.add("预约结果");

        fragmentList.add(new IndexFragment());
        fragmentList.add(new QueryFragment());
        fragmentList.add(new ReserveFragment());
        fragmentList.add(new ReserveResultFragment());
        Log.d(Constant.TAG_D, "initDate: ----------------> fagmentList size "+fragmentList.size());
    }
}