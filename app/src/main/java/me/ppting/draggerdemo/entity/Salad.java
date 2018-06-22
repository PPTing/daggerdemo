package me.ppting.draggerdemo.entity;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by PPTing on 2018/6/19.
 * Description:
 */
public class Salad {

    @Inject
    Apple apple;

    @Inject
    Banana banana;


    public void makeSalad(){
        Log.d("Salad","i have an "+apple.getColor()+" apple");
//        Log.d("Salad","i have an "+anotherApple.getColor()+" apple");
        Log.d("Salad","i have an banana"+banana);

    }


}
