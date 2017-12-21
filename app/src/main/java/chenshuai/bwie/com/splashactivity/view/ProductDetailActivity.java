package chenshuai.bwie.com.splashactivity.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import chenshuai.bwie.com.splashactivity.R;
import chenshuai.bwie.com.splashactivity.bean.ProBean;
import chenshuai.bwie.com.splashactivity.presenter.ProPresenter;

public class ProductDetailActivity extends AppCompatActivity implements IProActivity, View.OnClickListener {

    /**
     * 购物车
     */
    private TextView mGoods;
    /**
     * 加入购物车
     */
    private TextView mAddgoods;
    private RecyclerView mRv;
    List<ProBean.DataBean> lists;
    /**
     * 商品列表
     */
    private TextView mTv;
    private ImageView mProIv;
    private TextView mTvtitle;
    private TextView mTvSubhead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xqy);
        ProPresenter presenter = new ProPresenter(this);
        presenter.getPro("1");
        initView();
    }

    @Override
    public void show(ProBean.DataBean list) {
/*        lists.add(list);
        ProAdapter adapter = new ProAdapter(this, lists);
        mRv.setAdapter(adapter);*/
        String[] split = list.getImages().split("\\|");
        Glide.with(this).load(split[0]).into(mProIv);
        mTvtitle.setText(list.getTitle());
        mTvSubhead.setText(list.getSubhead());
    }

    private void initView() {
        mGoods = (TextView) findViewById(R.id.goods);
        mGoods.setOnClickListener(this);
        mAddgoods = (TextView) findViewById(R.id.addgoods);
        mAddgoods.setOnClickListener(this);

        mTv = (TextView) findViewById(R.id.tv);
        mProIv = (ImageView) findViewById(R.id.pro_iv);
        mTvtitle = (TextView) findViewById(R.id.tvtitle);
        mTvSubhead = (TextView) findViewById(R.id.tvSubhead);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.goods:
                Intent intent = new Intent(this,GoodsCardActivity.class);
                startActivity(intent);

                break;
            case R.id.addgoods:
                Toast.makeText(this,"加入成功",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
