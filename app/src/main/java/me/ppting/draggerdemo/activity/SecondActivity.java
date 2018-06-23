package me.ppting.draggerdemo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import me.ppting.draggerdemo.ComponentHolder;
import me.ppting.draggerdemo.R;
import me.ppting.draggerdemo.adapter.Items;
import me.ppting.draggerdemo.adapter.ListAdapter;
import me.ppting.draggerdemo.net.ApiRequest;
import me.ppting.draggerdemo.net.NetWorkCallback;

/**
 * Created by PPTing on 2018/6/21.
 * Description:
 */
public class SecondActivity extends AppCompatActivity {

    private ListAdapter listAdapter;

    @Inject
    ApiRequest apiRequest;

    public static void start(Context context, String result) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("result", result);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ComponentHolder.getSaladComponent().inject(this);
        initView();
        getApi();
    }

    private void initView() {
        TextView tvResultInSecond = findViewById(R.id.tv_result_in_second);
        tvResultInSecond.setText(getIntent().getStringExtra("result"));
        RecyclerView rvList = findViewById(R.id.rv_list);
        rvList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        listAdapter = new ListAdapter();
        rvList.setAdapter(listAdapter);
    }

    private void getApi(){
        apiRequest.getSomething("param", new NetWorkCallback<List<Items>>() {
            @Override
            public void onSuccess(List<Items> items) {
                listAdapter.setItems(items);
            }

            @Override
            public void onFail() {

            }
        });
    }
}
