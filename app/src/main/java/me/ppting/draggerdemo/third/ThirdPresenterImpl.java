package me.ppting.draggerdemo.third;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import me.ppting.draggerdemo.ComponentHolder;
import me.ppting.draggerdemo.adapter.Items;
import me.ppting.draggerdemo.net.ApiRequest;
import me.ppting.draggerdemo.net.NetWorkCallback;

/**
 * Created by PPTing on 2018/6/23.
 * Description:
 */

public class ThirdPresenterImpl implements ThirdContract.Presenter {

    private ThirdContract.Model model ;

    private ThirdContract.View view ;

    @Inject
    ApiRequest apiRequest;

    @Inject
    public ThirdPresenterImpl(ThirdModel model) {
        this.model = model;
        ComponentHolder.getSaladComponent().inject(this);
    }

    public void init(ThirdContract.View view){
        this.view = view;

    }


    @Override
    public void getSomething() {

        apiRequest.getSomething("34567", new NetWorkCallback<List<Items>>() {
            @Override
            public void onSuccess(List<Items> items) {
                view.showSomething(items);
            }

            @Override
            public void onFail() {

            }
        });
    }
}