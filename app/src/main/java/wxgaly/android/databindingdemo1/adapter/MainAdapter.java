package wxgaly.android.databindingdemo1.adapter;

import android.view.View;

import java.util.List;

import wxgaly.android.databindingdemo1.R;

/**
 * Created by wxgaly on 2016/12/11.
 */

public class MainAdapter extends BaseQuickAdapter<String> {


    private OnItemClickListener onItemClickListener;

    public MainAdapter(int resId, List<String> datas) {
        super(resId, datas);
    }

    @Override
    public void convert(BaseViewHolder holder, final String data) {
        holder.setText(R.id.item_tv_name, data);

    }

    @Override
    public void convert(BaseViewHolder holder, final int position) {
        holder.getView(R.id.ll_main_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.OnItemClick(v, position);
                }
            }
        });
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
