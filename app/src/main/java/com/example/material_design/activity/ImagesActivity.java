package com.example.material_design.activity;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.material_design.R;

import org.w3c.dom.Text;

public class ImagesActivity extends AppCompatActivity {
public static final String IMAGE_NAME = "image_naem";
    public  static final String IMAGE_ID="image_id";
    private Toolbar mToolBar;
    private CollapsingToolbarLayout mCollapsingToolbar;
    private ImageView mImageView;
    private TextView mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);
        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        mCollapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        mImageView = (ImageView) findViewById(R.id.image_view);
        mContent = (TextView) findViewById(R.id.tv_content);
        initBar();
        initIntent();
    }

    private void initBar() {
        setSupportActionBar(mToolBar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void initIntent() {
        Intent intent = getIntent();
        String name = intent.getStringExtra(IMAGE_NAME);
        int imageId = intent.getIntExtra(IMAGE_ID, 0);
        mCollapsingToolbar.setTitle(name);
        Glide.with(this).load(imageId).into(mImageView);
        String ImageName = generateImageContent(name);
        mContent.setText(ImageName);
    }

    private String generateImageContent(String name) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <500 ; i++) {
            builder.append(name);
        }
        return builder.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
