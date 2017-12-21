package chenshuai.bwie.com.splashactivity.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.List;

import chenshuai.bwie.com.splashactivity.R;
import chenshuai.bwie.com.splashactivity.adapter.ElvAdapter;
import chenshuai.bwie.com.splashactivity.bean.GoodsCardBean;
import chenshuai.bwie.com.splashactivity.presenter.GoodsCardPresenter;

public class GoodsCardActivity extends AppCompatActivity implements IGoodsCard, View.OnClickListener {


    /**
     * 全选
     */
    private CheckBox mCb;
    /**
     * 合计:
     */
    private TextView mTvTotal;
    /**
     * 去结算(0)
     */

    private ExpandableListView mElv;
    private GoodsCardPresenter goodsCardPresenter;
    private TextView mTvCount;
    private ElvAdapter adapter;
private double price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_card);
        initView();
        goodsCardPresenter = new GoodsCardPresenter(this);

        goodsCardPresenter.getCards("3402");

        //给全选设置点击事件
        mCb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (adapter != null) {
                    adapter.setAllChecked(mCb.isChecked());
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        goodsCardPresenter.dettach();
    }

    @Override
    public void show(List<GoodsCardBean.DataBean> group, List<List<GoodsCardBean.DataBean.ListBean>> child) {
        //设置适配器
        adapter = new ElvAdapter(this, group, child);
        mElv.setAdapter(adapter);

        for (int i = 0; i < group.size(); i++) {
            mElv.expandGroup(i);
        }
    }

    private void initView() {
        mElv = (ExpandableListView) findViewById(R.id.elv);
        mElv.setGroupIndicator(null);
        mCb = (CheckBox) findViewById(R.id.cb);
        mTvTotal = (TextView) findViewById(R.id.tvTotal);
        mTvCount = (TextView) findViewById(R.id.tvCount);
        mTvCount.setOnClickListener(this);
    }

    public void setMoney(double price) {
        this.price =price;
        mTvTotal.setText("合计：" + price);
    }

    public void setCount(int count) {
        mTvCount.setText("去结算(" + count + ")");
    }

    public void setAllSelect(boolean bool) {
        mCb.setChecked(bool);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvCount:
                Intent intent = new Intent(this, QVActivity.class);
                intent.putExtra("price",price);
                startActivity(intent);
                break;
        }
    }
}
