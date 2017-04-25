package wxgaly.android.testdemo1.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by wxgaly on 2016/12/11.
 */

public abstract class BaseQuickAdapter<T> extends RecyclerView.Adapter<BaseQuickAdapter.BaseViewHolder> {


    private int mResId;
    private List<T> mDatas;
    private BaseViewHolder mBaseViewHolder;
    protected Context mContext;

    public BaseQuickAdapter(int resId, List<T> datas) {
        this.mResId = resId;
        this.mDatas = datas;

    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        mBaseViewHolder = new BaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(mResId, parent, false));
        return mBaseViewHolder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        convert(holder, position);
        if (mDatas == null) {
            convert(holder, null);
        } else {
            convert(holder, mDatas.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    public abstract void convert(BaseViewHolder holder, T data);

    public void convert(BaseViewHolder holder, int position) {

    }

    public List<T> getData() {
        return mDatas;
    }

    public void setNewData(List<T> newData) {
        mDatas = newData;
        notifyDataSetChanged();
    }

    public static class BaseViewHolder extends RecyclerView.ViewHolder {

        public BaseViewHolder(View itemView) {
            super(itemView);
        }

        public void setText(int resId, CharSequence content) {
            ((TextView) (itemView.findViewById(resId))).setText(content);
        }

        public void setImageResoure(int resId, @DrawableRes int drawableRes) {
            ((ImageView) itemView.findViewById(resId)).setImageResource(drawableRes);
        }

        public void setImageBitmap(int resId, Bitmap bitmap) {
            ((ImageView) itemView.findViewById(resId)).setImageBitmap(bitmap);
        }

        public View getView(int viewId) {
            return itemView.findViewById(viewId);
        }

    }

    public static interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

}
