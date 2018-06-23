package me.ppting.draggerdemo.third;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import me.ppting.draggerdemo.adapter.Items;

/**
 * Created by PPTing on 2018/6/23.
 * Description:
 */

public class ThirdPresenterImpl implements ThirdContract.Presenter {

    private ThirdContract.Model model ;
    private ThirdContract.View view ;

    @Inject
    public ThirdPresenterImpl(ThirdModel model) {
        this.model = model;
    }

    public void init(ThirdContract.View view){
        this.view = view;

    }


    @Override
    public void getSomething() {
        Log.d("ThirdPresenter","get something ");
        List<Items> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Items("name "+i));
        }
        view.showSomething(list);
    }
}