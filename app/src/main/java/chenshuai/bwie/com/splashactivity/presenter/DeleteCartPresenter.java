package chenshuai.bwie.com.splashactivity.presenter;

import java.util.HashMap;
import java.util.Map;

import chenshuai.bwie.com.splashactivity.bean.BaseBean;
import chenshuai.bwie.com.splashactivity.model.DeleCartService;
import chenshuai.bwie.com.splashactivity.model.IDeleteCartService;
import chenshuai.bwie.com.splashactivity.net.OnNetListener;
import chenshuai.bwie.com.splashactivity.view.IDelCard;


/**
 * Created by peng on 2017/12/13.
 */

public class DeleteCartPresenter {
    private IDeleteCartService iDeleteCartService;
    private IDelCard iDelCard;

    public DeleteCartPresenter(IDelCard iDelCard) {
        this.iDelCard = iDelCard;
        iDeleteCartService = new DeleCartService();
    }

    public void deleteCart(String uid, String pid) {
        Map<String, String> params = new HashMap<>();
        params.put("uid", uid);
        params.put("pid", pid);
        iDeleteCartService.deleteCart(params, new OnNetListener<BaseBean>() {
            @Override
            public void onSuccess(BaseBean baseBean) {
                iDelCard.Onsuccess();
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
