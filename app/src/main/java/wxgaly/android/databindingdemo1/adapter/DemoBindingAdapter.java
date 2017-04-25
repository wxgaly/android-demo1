package wxgaly.android.databindingdemo1.adapter;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by wxgaly on 2016/12/15.
 */

public class DemoBindingAdapter {

    @BindingAdapter({"app:imageUrl", "app:placeholder"})
    public static void loadImageFromUrl(ImageView imageView,
                                        String url, Drawable drawable){
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(drawable)
                .into(imageView);
    }

}
