package me.ppting.draggerdemo.third;


import java.util.List;

import me.ppting.draggerdemo.adapter.Items;

/**
 * Created by PPTing on 2018/6/23.
 * Description:
 */


public class ThirdContract {

    public interface View {
        void showSomething(List<Items> items);
    }

    public interface Presenter {
        void getSomething();
    }

    public interface Model {

    }
}