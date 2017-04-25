package wxgaly.android.testdemo1.adapter.news;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import wxgaly.android.testdemo1.R;
import wxgaly.android.testdemo1.adapter.BaseQuickAdapter;
import wxgaly.android.testdemo1.model.news.NewsBean;

/**
 * Created by wxgaly on 2017/1/9.
 */

public class NewsAdapter extends BaseQuickAdapter<NewsBean> {

    private static final int ONE_PIC = 0x00;
    private static final int THREE_PIC = 0x01;
    private OnItemClickListener mOnItemClickListener;

    public NewsAdapter(int resId, List<NewsBean> datas) {
        super(resId, datas);
    }

    @Override
    public void convert(BaseViewHolder holder, final NewsBean data) {

        holder.getView(R.id.news_item_cardview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnItemClickListener != null){
                    mOnItemClickListener.onItemClick(v, data);
                }
            }
        });

        holder.setText(R.id.news_item_tv_title, data.title);
        holder.setText(R.id.news_item_tv_date, data.date);
        holder.setText(R.id.news_item_tv_author, data.authorName);

        if (!TextUtils.isEmpty(data.thumbnailPicS02) && !TextUtils.isEmpty(data.thumbnailPicS03)) {

            Glide.with(mContext).load(data.thumbnailPicS02)
                    .into((ImageView) holder.getView(R.id.news_item_iv_thumbnail_pic_s02));

            Glide.with(mContext).load(data.thumbnailPicS03)
                    .into((ImageView) holder.getView(R.id.news_item_iv_thumbnail_pic_s03));
        }

        Glide.with(mContext).load(data.thumbnailPicS01)
                .into((ImageView) holder.getView(R.id.news_item_iv_thumbnail_pic_s));


    }

    @Override
    public int getItemViewType(int position) {

        NewsBean data = getData().get(position);

        if (!TextUtils.isEmpty(data.thumbnailPicS02) && !TextUtils.isEmpty(data.thumbnailPicS03)) {
            return THREE_PIC;
        } else {
            return ONE_PIC;
        }

    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == ONE_PIC) {

            return new BaseViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.news_item_one_pic, parent, false));
        } else if (viewType == THREE_PIC) {

            return super.onCreateViewHolder(parent, viewType);
        } else {
            return super.onCreateViewHolder(parent, viewType);
        }

    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public static interface OnItemClickListener {
        void onItemClick(View view, NewsBean data);
    }

}
