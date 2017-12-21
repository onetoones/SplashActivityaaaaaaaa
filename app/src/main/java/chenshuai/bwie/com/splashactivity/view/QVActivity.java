package chenshuai.bwie.com.splashactivity.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import chenshuai.bwie.com.splashactivity.R;

public class QVActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 实付款：￥
     */
    private TextView mCountprice;
    /**
     * 立即下单
     */
    private Button mBtnTz;
    private RelativeLayout mRl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qv);
     /*   Intent intent = getIntent();

        double price = intent.getDoubleExtra("price", 1.0);
        String s = String.valueOf(price);*/

        initView();
    }

    private void initView() {
        mCountprice = (TextView) findViewById(R.id.countprice);
        mBtnTz = (Button) findViewById(R.id.btn_tz);
        mBtnTz.setOnClickListener(this);
        mRl = (RelativeLayout) findViewById(R.id.rl);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_tz:
                break;
        }
    }
}
