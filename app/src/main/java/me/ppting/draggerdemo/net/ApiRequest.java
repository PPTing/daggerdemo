package me.ppting.draggerdemo.net;

import java.util.ArrayList;
import java.util.List;

import me.ppting.draggerdemo.adapter.Items;

/**
 * Created by PPTing on 2018/6/23.
 * Description:
 */
public class ApiRequest {

    public void getSomething(String param,NetWorkCallback<List<Items>> netWorkCallback){
        //模拟网络请求异步延时
        //制造数据
        List<Items> items = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            items.add(new Items("name "+i));
        }
        netWorkCallback.onSuccess(items);
    }
}
