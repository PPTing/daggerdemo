package me.ppting.draggerdemo;

import me.ppting.draggerdemo.component.SaladComponent;

/**
 * Created by PPTing on 2018/6/23.
 * Description:
 */
public class ComponentHolder {
    private static SaladComponent mSaladComponent;

    public static void setSaladComponent(SaladComponent saladComponent){
        mSaladComponent = saladComponent;
    }

    public static SaladComponent getSaladComponent() {
        return mSaladComponent;
    }
}
