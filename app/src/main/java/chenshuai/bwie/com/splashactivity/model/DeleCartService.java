package chenshuai.bwie.com.splashactivity.model;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;

import chenshuai.bwie.com.splashactivity.bean.BaseBean;
import chenshuai.bwie.com.splashactivity.net.Api;
import chenshuai.bwie.com.splashactivity.net.OkHttpUtils;
import chenshuai.bwie.com.splashactivity.net.OnNetListener;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by peng on 2017/12/13.
 */

public class DeleCartService implements IDeleteCartService {
    private Handler handler = new Handler(Looper.myLooper());

    @Override
    public void deleteCart(Map<String, String> params, final OnNetListener<BaseBean> onNetListener) {
        OkHttpUtils.getOkHttpUtils().doPost(Api.DEL_CARD, params, new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.onFailure(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        BaseBean baseBean = new Gson().fromJson(string, BaseBean.class);
                        onNetListener.onSuccess(baseBean);
                    }
                });
            }
        });
    }
}
