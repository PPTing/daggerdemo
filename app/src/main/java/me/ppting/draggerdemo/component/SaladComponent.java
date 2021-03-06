package me.ppting.draggerdemo.component;

import dagger.Component;
import me.ppting.draggerdemo.ITest;
import me.ppting.draggerdemo.activity.SecondActivity;
import me.ppting.draggerdemo.entity.Salad;
import me.ppting.draggerdemo.model.SaladModel;
import me.ppting.draggerdemo.third.ThirdActivity;
import me.ppting.draggerdemo.third.ThirdPresenterImpl;

/**
 * Created by PPTing on 2018/6/19.
 * Description:
 */

@Component(modules = SaladModel.class)
public interface SaladComponent {

    void inject(Salad salad);

    ITest getTest();

    void inject(SecondActivity activity);

    void inject(ThirdActivity thirdActivity);

    void inject(ThirdPresenterImpl thirdPresenter);
}
