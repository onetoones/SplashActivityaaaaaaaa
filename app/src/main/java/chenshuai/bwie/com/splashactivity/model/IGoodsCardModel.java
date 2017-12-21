package chenshuai.bwie.com.splashactivity.model;

import java.util.Map;

import chenshuai.bwie.com.splashactivity.bean.GoodsCardBean;
import chenshuai.bwie.com.splashactivity.net.OnNetListener;

/**
 * Created by peng on 2017/12/12.
 */

public interface IGoodsCardModel {
    void getCarts(Map<String, String> params, OnNetListener<GoodsCardBean> onNetListener);
}
