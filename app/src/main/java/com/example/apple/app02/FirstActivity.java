package com.example.apple.app02;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mText;
    private ImageView mImage;
    private int num;
    private int index;
    private String[] title;
    private int[] images;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initView();
        initData();
    }

    private void initData() {
        title = new String[]{"horse", "elephant", "lion", "tiger", "panda", "deer", "cat"};
        images = new int[]{R.drawable.horse, R.drawable.elephant, R.drawable.lion, R.drawable.tiger, R.drawable.panda, R.drawable.deer, R.drawable.cat};
        mImage.setImageResource(images[0]);
        mText.setText(title[0]);
        num = title.length;
        index = 0;
    }

    private void initView() {
        mImage = findViewById(R.id.iv_show);
        mText = findViewById(R.id.tv_show);
        findViewById(R.id.btn_previous).setOnClickListener(this);
        findViewById(R.id.btn_next).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_previous:
                if (index == 0) {
                    index = num - 1;
                } else {
                    index--;
                }
                break;
            case R.id.btn_next:
                if (index == num - 1) {
                    index = 0;
                } else {
                    index++;
                }
                break;
        }
        upDateImageAndTitle();
    }

    private void upDateImageAndTitle() {
        mImage.setImageResource(images[index]);
        mText.setText(title[index]);
    }
}
