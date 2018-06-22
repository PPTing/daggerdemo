package me.ppting.draggerdemo.model;

import dagger.Module;
import dagger.Provides;
import me.ppting.draggerdemo.ITest;
import me.ppting.draggerdemo.Test;
import me.ppting.draggerdemo.entity.Apple;
import me.ppting.draggerdemo.entity.Banana;

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
}
