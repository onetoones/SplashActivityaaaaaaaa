package chenshuai.bwie.com.splashactivity.view;

import java.util.List;

import chenshuai.bwie.com.splashactivity.bean.GoodsCardBean;

/**
 * 姓名：陈帅
 * 类作用：
 * 日期：
 */

public interface IGoodsCard {
    void show(List<GoodsCardBean.DataBean> group, List<List<GoodsCardBean.DataBean.ListBean>> child);
}
