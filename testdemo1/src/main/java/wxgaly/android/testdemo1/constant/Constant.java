package wxgaly.android.testdemo1.constant;

/**
 * Created by wxgaly on 2016/12/28.
 */

public class Constant {


    public static class ActivityConstant {
        public static final int ACTIVITY_TYPE_NEWS = 0x00;
        public static final int ACTIVITY_TYPE_WEATHER_FORECAST = 0x01;
    }

    public static class AppKey {

        public static final String NEWS_KEY = "1bb177cf7a92e3168f6c06c53cba717a";
    }


    public static class ErrorDetail {

        public int errorCode;
        public String errorDetail;

        public ErrorDetail(int errorCode, String errorDetail) {
            this.errorCode = errorCode;
            this.errorDetail = errorDetail;
        }
    }

    public static class ErrorCode {
        public static final int ERROR = 0x00;
    }

    public static class RequestURL {

        public static final String NEWS_BASE_URL = " http://v.juhe.cn/toutiao";
        public static final String NEWS_SUFFIX_URL = "/index";


    }

    public static class RequestQueryKey {
        public static final String KEY_STR = "key";
        public static final String NEWS_TYPE_STR = "type";

    }

    public static class NewsType {

        public static final String TYPE_TOP = "top";
        public static final String TYPE_SHEHUI = "shehui";
        public static final String TYPE_GUONEI = "guonei";
        public static final String TYPE_GUOJI = "guoji";
        public static final String TYPE_YULE = "yule";
        public static final String TYPE_TIYU = "tiyu";
        public static final String TYPE_JUNSHI = "junshi";
        public static final String TYPE_KEJI = "keji";
        public static final String TYPE_CAIJING = "caijing";
        public static final String TYPE_SHISHANG = "shishang";

        public static final String TOP = "头条";
        public static final String SHEHUI = "社会";
        public static final String GUONEI = "国内";
        public static final String GUOJI = "国际";
        public static final String YULE = "娱乐";
        public static final String TIYU = "体育";
        public static final String JUNSHI = "军事";
        public static final String KEJI = "科技";
        public static final String CAIJING = "财经";
        public static final String SHISHANG = "时尚";

        public static String[] newsTypeList = new String[]{Constant.NewsType.TYPE_TOP,
                Constant.NewsType.TYPE_YULE, Constant.NewsType.TYPE_KEJI, Constant.NewsType.TYPE_SHISHANG,
                Constant.NewsType.TYPE_SHEHUI, Constant.NewsType.TYPE_TIYU, Constant.NewsType.TYPE_CAIJING,
                Constant.NewsType.TYPE_GUONEI, Constant.NewsType.TYPE_GUOJI
        };

        public static String[] newsNameList = new String[]{Constant.NewsType.TOP,
                Constant.NewsType.YULE, Constant.NewsType.KEJI, Constant.NewsType.SHISHANG,
                Constant.NewsType.SHEHUI, Constant.NewsType.TIYU, Constant.NewsType.CAIJING,
                Constant.NewsType.GUONEI, Constant.NewsType.GUOJI
        };

    }

    public static class IntentKey{
        public static final String URL = "url";
    }

}
