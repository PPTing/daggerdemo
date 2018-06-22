package me.ppting.draggerdemo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import me.ppting.draggerdemo.R;

/**
 * Created by PPTing on 2018/6/21.
 * Description:
 */
public class SecondActivity extends AppCompatActivity {

    public static void start(Context context,String result){
        Intent intent = new Intent(context,SecondActivity.class);
        intent.putExtra("result",result);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
    }

    private void initView() {
        TextView tvResultInSecond = findViewById(R.id.tv_result_in_second);
        tvResultInSecond.setText(getIntent().getStringExtra("result"));
    }
}
