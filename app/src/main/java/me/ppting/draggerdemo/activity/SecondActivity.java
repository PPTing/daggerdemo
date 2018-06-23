package me.ppting.draggerdemo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.ppting.draggerdemo.R;
import me.ppting.draggerdemo.adapter.Items;
import me.ppting.draggerdemo.adapter.ListAdapter;

/**
 * Created by PPTing on 2018/6/21.
 * Description:
 */
public class SecondActivity extends AppCompatActivity {

    public static void start(Context context, String result) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("result", result);
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
        RecyclerView rvList = findViewById(R.id.rv_list);
        rvList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        //制造数据
        List<Items> items = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            items.add(new Items("name "+i));
        }
        ListAdapter listAdapter = new ListAdapter(items);
        rvList.setAdapter(listAdapter);
        listAdapter.notifyDataSetChanged();
    }
}
