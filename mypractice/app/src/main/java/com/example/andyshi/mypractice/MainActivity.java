package com.example.andyshi.mypractice;

import android.support.v4.app.Fragment;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Toolbar toolbar;
    private int[] IconResId = {R.drawable.homeselector,R.drawable.humanselector};
    private int[] ToolBarTitle = {R.string.home,R.string.students};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager)findViewById(R.id.myViewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        toolbar = (Toolbar)findViewById(R.id.ToolBar);
        toolbar.setTitle(ToolBarTitle[0]);
        toolbar.setTitleTextColor(Color.BLACK);
        setSupportActionBar(toolbar);
        setViewPager();
        tabLayout.setupWithViewPager(viewPager);
        setTabLayoutIcon();

    }

    private void setTabLayoutIcon() {
        for(int i=0;i<2;i++){
            tabLayout.getTabAt(i).setIcon(IconResId[i]);
        }
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                toolbar.getMenu().clear();
                switch (tab.getPosition()){
                    case 0:
                        toolbar.inflateMenu(R.menu.menu_one);
                        toolbar.setTitle(ToolBarTitle[0]);
                        break;
                    case 1:
                        toolbar.inflateMenu(R.menu.menu_two);
                        toolbar.setTitle(ToolBarTitle[1]);
                        break;
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void setViewPager() {
        IndexFragment fragment1 = new IndexFragment();
        Fragment_ListOne fragment2 = new Fragment_ListOne();
        ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
        fragmentList.add(fragment1);
        fragmentList.add(fragment2);
        ViewPagerFragmentAdapter viewPagerFragmentAdapter = new ViewPagerFragmentAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(viewPagerFragmentAdapter);

    }
}
