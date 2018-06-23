package me.ppting.draggerdemo.net;

/**
 * Created by PPTing on 2018/6/23.
 * Description:
 */
public interface NetWorkCallback<T> {
    void onSuccess(T t);

    void onFail();
}
