package chenshuai.bwie.com.splashactivity.model;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;

import chenshuai.bwie.com.splashactivity.bean.GoodsCardBean;
import chenshuai.bwie.com.splashactivity.net.Api;
import chenshuai.bwie.com.splashactivity.net.OkHttpUtils;
import chenshuai.bwie.com.splashactivity.net.OnNetListener;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by peng on 2017/12/12.
 */

public class GoodsCardModel implements IGoodsCardModel {
    private Handler handler = new Handler(Looper.myLooper());

    @Override
    public void getCarts(Map<String, String> params, final OnNetListener<GoodsCardBean> onNetListener) {
        OkHttpUtils.getOkHttpUtils().doPost(Api.SELECT_CARD, params, new Callback() {
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
                        GoodsCardBean goodsCardBean = new Gson().fromJson(string, GoodsCardBean.class);
                        onNetListener.onSuccess(goodsCardBean);
                    }
                });
            }
        });
    }
}
