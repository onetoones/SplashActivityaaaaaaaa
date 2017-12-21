package chenshuai.bwie.com.splashactivity.net;

/**
 * Created by peng on 2017/12/1.
 */

public interface OnNetListener<T> {
    public void onSuccess(T t);

    public void onFailure(Exception e);
}
