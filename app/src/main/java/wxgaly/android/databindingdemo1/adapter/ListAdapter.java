package wxgaly.android.databindingdemo1.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.databinding.library.baseAdapters.BR;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import wxgaly.android.databindingdemo1.R;
import wxgaly.android.databindingdemo1.bean.User;

/**
 * Created by wxgaly on 2016/12/13.
 */

public class ListAdapter extends RecyclerView.Adapter<BindingViewHolder> {

    private static final int ITEM_VIEW_TYPE_ON = 1;
    private static final int ITEM_VIEW_TYPE_OFF = 2;

    private OnItemClickListener onItemClickListener;
    private List<User> mDatas = new ArrayList<>();

    public ListAdapter() {

    }

    @Override
    public int getItemViewType(int position) {

        final User user = mDatas.get(position);

        if (user.isStudent.get()) {
            return ITEM_VIEW_TYPE_OFF;
        } else {
            return ITEM_VIEW_TYPE_ON;
        }

    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding;

        if (viewType == ITEM_VIEW_TYPE_ON) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                    R.layout.item_list_on, parent, false);
        } else {
            binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                    R.layout.item_list_off, parent, false);
        }

        return new BindingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final BindingViewHolder holder, int position) {

        final User user = mDatas.get(position);
        holder.getBinding().setVariable(BR.item, user);
        holder.getBinding().executePendingBindings();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.OnItemClick(v, user);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void OnItemClick(View view, User user);
    }

    public void addAll(List<User> users) {
        mDatas.addAll(users);
        notifyDataSetChanged();
    }

    Random random = new Random(System.currentTimeMillis());

    public void add(User user) {
        int position = random.nextInt(mDatas.size() + 1);
        mDatas.add(position, user);
        notifyItemInserted(mDatas.size());
    }

    public void remove() {
        if (mDatas.size() == 0) {
            return;
        }
        int position = random.nextInt(mDatas.size());

        mDatas.remove(position);
        notifyItemRemoved(position);
    }
}
