package me.ppting.draggerdemo;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import me.ppting.draggerdemo.adapter.Items;
import me.ppting.draggerdemo.component.DaggerSaladComponent;
import me.ppting.draggerdemo.component.SaladComponent;
import me.ppting.draggerdemo.model.SaladModel;
import me.ppting.draggerdemo.net.ApiRequest;
import me.ppting.draggerdemo.net.NetWorkCallback;
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
    static ApiRequest apiRequest;


    @BeforeClass
    public static void setUp(){
        SaladModel saladModel = Mockito.mock(SaladModel.class);

        apiRequest = Mockito.mock(ApiRequest.class);

        //制造数据
        final List<Items> items = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            Items item = new Items("mock name "+i);
            items.add(item);
        }

        //将 apiRequest 回调的数据替换成 items 并调用 onSuccess 方法
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] args = invocation.getArguments();
                NetWorkCallback asyncCallBackAdapter = (NetWorkCallback) args[1];
                asyncCallBackAdapter.onSuccess(items);
                return null;
            }
        }).when(apiRequest)
                .getSomething(Mockito.anyString(),Mockito.any(NetWorkCallback.class));

        //将 provider 中提供的 apiRequest 对象替换成mock出来的 apiRequest
        Mockito.when(saladModel.providerApiRequest()).thenReturn(apiRequest);


        SaladComponent saladComponent = DaggerSaladComponent.builder().saladModel(saladModel).build();
        ComponentHolder.setSaladComponent(saladComponent);
    }


    /**
     * 测试 mock 假数据
     */
    @Test
    public void testMockData(){


    }


}
