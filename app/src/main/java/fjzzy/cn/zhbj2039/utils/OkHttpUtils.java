package fjzzy.cn.zhbj2039.utils;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.telecom.Call;
import android.util.Log;
import android.widget.ProgressBar;

import java.io.IOException;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpUtils {
    public static OkHttpClient okHttpClient = new OkHttpClient();

    public static void getAsnyRequest(final String URL, Callback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Request request = new Request.Builder()
                        .url(URL)
                        .build();
                okHttpClient.newCall(request).enqueue(callback);
            }
        }).start();

    }//TODO:getAsnyRequest


    public static void postAsnyRequest(final String URL, Callback callback, RequestBody requestBody) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Request request = new Request.Builder()
                        .url(URL)
                        .post(requestBody)
                        .build();
                okHttpClient.newCall(request).enqueue(callback);
            }
        }).start();
    }//TODO:postAsnyRequest

    //@NonNull(handler)
    public static void getRequest(final String URL, Handler handler, int what) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Request request = new Request.Builder()
                        .url(URL)
                        .build();
                Response response = null;
                try {
                    response = okHttpClient.newCall(request).execute();
                    Message message = new Message();
                    message.what = what;
                    message.obj = response;
                    handler.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }//TODO:getRequest

    public static void postRequest(final String URL, RequestBody requestBody, Handler handler, int what) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Request request = new Request.Builder()
                        .url(URL).post(requestBody)
                        .build();
                Response response = null;
                try {
                    response = okHttpClient.newCall(request).execute();
                    Message message = new Message();
                    message.what = what;
                    message.obj = response;
                    handler.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }//TODO:postRequest

}
