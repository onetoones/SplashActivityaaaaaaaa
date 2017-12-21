package chenshuai.bwie.com.splashactivity.presenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import chenshuai.bwie.com.splashactivity.bean.GoodsCardBean;
import chenshuai.bwie.com.splashactivity.model.GoodsCardModel;
import chenshuai.bwie.com.splashactivity.model.IGoodsCardModel;
import chenshuai.bwie.com.splashactivity.net.OnNetListener;
import chenshuai.bwie.com.splashactivity.view.IGoodsCard;


/**
 * Created by peng on 2017/12/12.
 */

public class GoodsCardPresenter {
    private IGoodsCardModel iGoodsCardModel;
    private IGoodsCard iGoodsCard;

    public GoodsCardPresenter(IGoodsCard iGoodsCard) {
        iGoodsCardModel = new GoodsCardModel();
        this.iGoodsCard = iGoodsCard;
    }

    public void dettach() {
        iGoodsCard = null;
    }

    public void getCards(String uid) {
        Map<String, String> params = new HashMap<>();
        params.put("uid", uid);
        params.put("source","android");
        iGoodsCardModel.getCarts(params, new OnNetListener<GoodsCardBean>() {
            @Override
            public void onSuccess(GoodsCardBean goodsCardBean) {
                List<List<GoodsCardBean.DataBean.ListBean>> child = new ArrayList<>();
                for (int i = 0; i < goodsCardBean.getData().size(); i++) {
                    child.add(goodsCardBean.getData().get(i).getList());
                }
                if (iGoodsCard != null) {
                    iGoodsCard.show(goodsCardBean.getData(), child);
                }
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
