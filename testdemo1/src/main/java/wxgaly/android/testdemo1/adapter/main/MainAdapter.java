package wxgaly.android.testdemo1.adapter.main;


import android.view.View;

import java.util.List;

import wxgaly.android.testdemo1.R;
import wxgaly.android.testdemo1.adapter.BaseQuickAdapter;

/**
 * Created by wxgaly on 2017/1/9.
 */

public class MainAdapter extends BaseQuickAdapter<String> {

    private OnItemClickListener mOnItemClickListener;

    public MainAdapter(int resId, List<String> datas) {
        super(resId, datas);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    @Override
    public void convert(BaseViewHolder holder, String data) {

        holder.setText(R.id.item_tv_name, data);

    }

    @Override
    public void convert(BaseViewHolder holder, final int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnItemClickListener != null){
                    mOnItemClickListener.onItemClick(v, position);
                }
            }
        });
    }
}
