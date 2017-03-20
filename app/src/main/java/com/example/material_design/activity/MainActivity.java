package com.example.material_design.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.material_design.Utils.SnackbarUtils;
import com.example.material_design.Utils.ToastUtils;
import com.example.material_design.adapter.ImageAdapter;
import com.example.material_design.javabean.Images;
import com.example.material_design.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavView;
    private FloatingActionButton mFab;

    private List<Images> mImagesList = new ArrayList<>();
    private Images[] mImages = {new Images("Apple", R.drawable.apple), new Images("Banana", R.drawable.banana), new Images("Orange", R.drawable.orange),
            new Images("Watermelon", R.drawable.watermelon), new Images("Pear", R.drawable.pear), new Images("Grape", R.drawable.grape),
            new Images("Pineapple", R.drawable.pineapple), new Images("Strawberry", R.drawable.strawberry), new Images("Cherry", R.drawable.cherry),
            new Images("Mango", R.drawable.mango),};
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefresh;
    private ImageAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //侧滑菜单
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        //侧滑菜单内容
        mNavView = (NavigationView) findViewById(R.id.nav_view);
        //悬浮按钮
        mFab = (FloatingActionButton) findViewById(R.id.fab);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }
        initNav();
        initImages();
        initRecyclerView();
    }

    private void initRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        mAdapter = new ImageAdapter(mImagesList);
        mRecyclerView.setAdapter(mAdapter);
        initSwipeRefresh();
    }

    private void initSwipeRefresh() {
        mSwipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        mSwipeRefresh.setColorSchemeResources(R.color.colorAccent);
        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshImages();
            }

            private void refreshImages() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                initImages();
                                mAdapter.notifyDataSetChanged();
                                mSwipeRefresh.setRefreshing(false);
                            }
                        });
                    }
                }).start();
            }
        });
    }

    private void initImages() {
        mImagesList.clear();
        for(int i=0;i<50;i++){
            Random random = new Random();
            int index = random.nextInt(mImages.length);
            mImagesList.add(mImages[index]);
        }
    }

    private void initNav() {
        //设置默认菜单内容选项为Call
        mNavView.setCheckedItem(R.id.nav_call);
        //点击菜单内容进行逻辑业务
        mNavView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //关闭滑动菜单
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //可交互提示工具
                SnackbarUtils.showSnackbar(MainActivity.this,v,"snackbar....","Todo");
            }
        });
    }
    //加载toolbar布局
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.backup:
                ToastUtils.showToast(this,"backup");
                break;
            case R.id.delete:
                ToastUtils.showToast(this,"delete");
                break;
            case R.id.setting:
                ToastUtils.showToast(this,"setting");
                break;
            default:
                break;
        }
        return true;
    }
}
