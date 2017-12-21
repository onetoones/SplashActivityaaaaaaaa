package chenshuai.bwie.com.splashactivity.model;

import java.util.Map;

import chenshuai.bwie.com.splashactivity.bean.BaseBean;
import chenshuai.bwie.com.splashactivity.net.OnNetListener;


/**
 * Created by peng on 2017/12/13.
 */

public interface IDeleteCartService {

    void deleteCart(Map<String, String> params, OnNetListener<BaseBean> onNetListener);
}
