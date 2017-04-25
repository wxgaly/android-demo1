package wxgaly.android.testdemo1.model.news;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wxgaly on 2016/12/31.
 */

public class NewsBean {

    public String title;
    public String date;
    @SerializedName("author_name")
    public String authorName;
    @SerializedName("thumbnail_pic_s")
    public String thumbnailPicS01;
    @SerializedName("thumbnail_pic_s02")
    public String thumbnailPicS02;
    @SerializedName("thumbnail_pic_s03")
    public String thumbnailPicS03;
    public String url;
    public String uniquekey;
    public String type;
    public String realtype;

}
