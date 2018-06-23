package me.ppting.draggerdemo;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import me.ppting.draggerdemo.adapter.Items;
import me.ppting.draggerdemo.component.DaggerSaladComponent;
import me.ppting.draggerdemo.component.SaladComponent;
import me.ppting.draggerdemo.model.SaladModel;
import me.ppting.draggerdemo.net.ApiRequest;
import me.ppting.draggerdemo.third.ThirdActivity;
import me.ppting.draggerdemo.third.ThirdPresenterImpl;

/**
 * Created by PPTing on 2018/6/23.
 * Description:
 */

@RunWith(AndroidJUnit4.class)
public class ThirdActivityTest {


    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(ThirdActivity.class);

    @Mock
    static ThirdPresenterImpl presenter;


    @BeforeClass
    public static void setUp(){
        SaladModel saladModel = Mockito.mock(SaladModel.class);

        presenter = Mockito.mock(ThirdPresenterImpl.class);

        Mockito.doNothing()
                .when(presenter)
                .getSomething();

        //将 provider 中提供的 apiRequest 对象替换成mock出来的 apiRequest
        Mockito.when(saladModel.providerPresenter()).thenReturn(presenter);

        SaladComponent saladComponent = DaggerSaladComponent.builder().saladModel(saladModel).build();
        ComponentHolder.setSaladComponent(saladComponent);
    }


    /**
     * 测试 mock 假数据
     */
    @Test
    public void testMockData(){
        List<Items> list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            list.add(new Items("mock name is "+i));
        }

        final List<Items> tmpList = list;
        final ThirdActivity thirdActivity= ((ThirdActivity)mActivityRule.getActivity());
        thirdActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {

                thirdActivity.showSomething(tmpList);
            }
        });

    }


}
