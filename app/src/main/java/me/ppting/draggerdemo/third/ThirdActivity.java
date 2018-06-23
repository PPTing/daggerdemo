package me.ppting.draggerdemo.third;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import me.ppting.draggerdemo.ComponentHolder;
import me.ppting.draggerdemo.R;
import me.ppting.draggerdemo.adapter.Items;
import me.ppting.draggerdemo.adapter.ListAdapter;


/**
 * Created by PPTing on 2018/6/23.
 * Description:
 */

public class ThirdActivity extends AppCompatActivity implements ThirdContract.View {

    @Inject
    ThirdPresenterImpl presenter;

    private ListAdapter listAdapter;

    public static void start(Context context){
        context.startActivity(new Intent(context,ThirdActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        initView();
        ComponentHolder.getSaladComponent().inject(this);
        presenter.init(this);
        presenter.getSomething();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initView() {

        RecyclerView rvThirdList = findViewById(R.id.rv_third_list);
        rvThirdList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        listAdapter = new ListAdapter();
        rvThirdList.setAdapter(listAdapter);
    }

    @Override
    public void showSomething(List<Items> items) {
        listAdapter.setItems(items);
    }
}

