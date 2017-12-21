package chenshuai.bwie.com.splashactivity.model;

import chenshuai.bwie.com.splashactivity.bean.ProBean;
import chenshuai.bwie.com.splashactivity.net.OnNetListener;

/**
 * 姓名：陈帅
 * 类作用：
 * 日期：
 */

public interface IProModel {
    public void getPro(String pid, final OnNetListener<ProBean> onNetListener);

}
