package com.example.zerolab.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.TableLayout;

import com.example.zerolab.R;
import com.example.zerolab.adapter.TabAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yating
 */
public class StudentActivity extends AppCompatActivity {
    private TabLayout tl_student;
    private ViewPager2 vp_student;
    private List<String> title = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();
    private TabAdapter tabAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_activity_student);
        initDate();
        //实例化适配器
        tabAdapter=new TabAdapter(getSupportFragmentManager(),getLifecycle(),fragmentList);
        //设置适配器
        vp_student.setAdapter(tabAdapter);
        //将tablayout与viewpager关联
        new TabLayoutMediator(tl_student, vp_student, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(title.get(position));
            }
        }).attach();
    }

    public void initDate(){
        tl_student=findViewById(R.id.tl_student);
        vp_student=findViewById(R.id.vp_student);

        title.add("首页");
        title.add("查询");
        title.add("预约");
        title.add("预约结果");

        fragmentList.add(new Fragment());
        fragmentList.add(new Fragment());
        fragmentList.add(new Fragment());
        fragmentList.add(new Fragment());
    }
}