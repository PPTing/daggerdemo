package me.ppting.draggerdemo;

import android.app.Application;

import me.ppting.draggerdemo.component.DaggerSaladComponent;
import me.ppting.draggerdemo.component.SaladComponent;
import me.ppting.draggerdemo.model.SaladModel;

/**
 * Created by PPTing on 2018/6/23.
 * Description:
 */
public class App extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        SaladComponent saladComponent = DaggerSaladComponent.builder().saladModel(new SaladModel()).build();
        ComponentHolder.setSaladComponent(saladComponent);

    }
}
