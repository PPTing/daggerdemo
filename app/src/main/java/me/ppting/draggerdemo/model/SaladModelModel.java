package me.ppting.draggerdemo.model;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by PPTing on 2018/6/20.
 * Description:
 */

@Module
public class SaladModelModel {


    @Provides
    SaladModel provideSaladModel(){
        return new SaladModel();
    }
}
