package fjzzy.cn.zhbj2039.utils;

import android.content.Context;

/**
 * 缓冲工具类
 */
public class CacheUtils {

    //写缓冲
    //以URL为key，以json为值
    public static void setCache(Context context, String key, String json) {
        //有时也会保存在本地文件中,以URL为文件名，以Json为文件内容,md5可以改变文件名为可读
        PrefUtils.putString(context, key, json);
    }

    //读缓冲
    public static String getCache(Context context, String key) {
        return PrefUtils.getString(context,key,null);
    }
}
