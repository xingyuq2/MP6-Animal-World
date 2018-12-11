package com.example.apple.app02;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mText;
    private ImageView mImage;
    private int num;
    private int index;
    private String[] title;
    private int[] images;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
        initData();
    }

    private void initData() {
        title = new String[]{"milkfish", "bass fish", "yellowfin tuna"};
        images = new int[]{R.drawable.milkfish, R.drawable.bassfish, R.drawable.yellowfintuna};
        mImage.setImageResource(images[0]);
        mText.setText(title[0]);
        num = title.length;
        index = 0;
    }

    private void initView() {
        mImage = findViewById(R.id.iv_show2);
        mText = findViewById(R.id.tv_show2);
        findViewById(R.id.btn_previous2).setOnClickListener(this);
        findViewById(R.id.btn_next2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_previous2:
                if (index == 0) {
                    index = num - 1;
                } else {
                    index--;
                }
                break;
            case R.id.btn_next2:
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
