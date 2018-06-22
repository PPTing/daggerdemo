package me.ppting.draggerdemo.component;

import dagger.Component;
import me.ppting.draggerdemo.activity.MainActivity;
import me.ppting.draggerdemo.model.SaladModelModel;

/**
 * Created by PPTing on 2018/6/20.
 * Description:
 */

@Component(modules = SaladModelModel.class)
public interface SaladModuleComponent {
    void inject(MainActivity activity);
}
