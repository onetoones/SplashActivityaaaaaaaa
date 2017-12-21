package chenshuai.bwie.com.splashactivity.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import chenshuai.bwie.com.splashactivity.R;
import chenshuai.bwie.com.splashactivity.bean.ProBean;

/**
 * 姓名：陈帅
 * 类作用：
 * 日期：
 */

public class ProAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<ProBean.DataBean> list;

    public ProAdapter(Context context, List<ProBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflate = View.inflate(context, R.layout.xqy_item, null);

        return new ViewHolder1(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder1 viewHolder1 = (ViewHolder1) holder;
        ProBean.DataBean dataBean = list.get(position);
        viewHolder1.tvSubhead.setText(dataBean.getSubhead());
        viewHolder1.tvtitle.setText(dataBean.getTitle());
        String[] split = dataBean.getImages().split("\\|");
        Glide.with(context).load(split[0]).into(viewHolder1.iv);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {

        private final ImageView iv;
        private final TextView tvtitle;
        private final TextView tvSubhead;

        public ViewHolder1(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.pro_iv);
            tvtitle = itemView.findViewById(R.id.tvtitle);
            tvSubhead = itemView.findViewById(R.id.tvSubhead);

        }
    }
}
