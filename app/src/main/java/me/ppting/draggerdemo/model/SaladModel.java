package me.ppting.draggerdemo.model;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import me.ppting.draggerdemo.ITest;
import me.ppting.draggerdemo.Test;
import me.ppting.draggerdemo.entity.Apple;
import me.ppting.draggerdemo.entity.Banana;
import me.ppting.draggerdemo.net.ApiRequest;
import me.ppting.draggerdemo.third.ThirdContract;
import me.ppting.draggerdemo.third.ThirdModel;
import me.ppting.draggerdemo.third.ThirdPresenterImpl;

/**
 * Created by PPTing on 2018/6/19.
 * Description:
 */

@Module
public class SaladModel {


    @Provides
    public Apple provideApple(){
        return new Apple();
    }


    @Provides
    public Banana provideBanana(){
        return new Banana();
    }

    @Provides
    public ITest provideTest(){
        return new Test();
    }

    @Provides
    public ApiRequest providerApiRequest(){
        return new ApiRequest();
    }

    @Provides
    public ThirdContract.Presenter providerPresenter(){
        return new ThirdPresenterImpl(new ThirdModel());
    }
}
