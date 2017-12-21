package chenshuai.bwie.com.splashactivity.model;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.IOException;

import chenshuai.bwie.com.splashactivity.bean.ProBean;
import chenshuai.bwie.com.splashactivity.net.OkHttpUtils;
import chenshuai.bwie.com.splashactivity.net.OnNetListener;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 姓名：陈帅
 * 类作用：
 * 日期：
 */

public class ProModel implements IProModel{
    private Handler handler = new Handler(Looper.getMainLooper());

    public void getPro(String pid, final OnNetListener<ProBean> onNetListener) {
        String url = "http://120.27.23.105/product/getProductDetail?pid=" + pid + "&source=android";

        OkHttpUtils.getOkHttpUtils().doGet(url, new Callback() {
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
                String string = response.body().string();
                final ProBean bean = new Gson().fromJson(string, ProBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.onSuccess(bean);
                    }
                });
            }
        });
    }
}
