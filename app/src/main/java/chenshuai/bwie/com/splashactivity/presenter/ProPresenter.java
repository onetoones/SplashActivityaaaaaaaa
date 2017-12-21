package chenshuai.bwie.com.splashactivity.presenter;

import chenshuai.bwie.com.splashactivity.bean.ProBean;
import chenshuai.bwie.com.splashactivity.model.IProModel;
import chenshuai.bwie.com.splashactivity.model.ProModel;
import chenshuai.bwie.com.splashactivity.net.OnNetListener;
import chenshuai.bwie.com.splashactivity.view.IProActivity;

/**
 * 姓名：陈帅
 * 类作用：
 * 日期：
 */

public class ProPresenter {
    private IProActivity activity;
    private final IProModel iProModel;

    public ProPresenter(IProActivity activity) {
        this.activity = activity;
        iProModel = new ProModel();
    }

    public void getPro(String pid) {

        iProModel.getPro(pid, new OnNetListener<ProBean>() {
            @Override
            public void onSuccess(ProBean proBean) {
                activity.show(proBean.getData());
            }

            @Override
            public void onFailure(Exception e) {

            }
        });

    }

}
