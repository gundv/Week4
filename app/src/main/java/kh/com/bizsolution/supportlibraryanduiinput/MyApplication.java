package kh.com.bizsolution.supportlibraryanduiinput;

import android.app.Application;
import android.graphics.Bitmap;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class MyApplication extends Application {
    public static RequestQueue queue;
    public static ImageLoader loader;

    @Override
    public void onCreate() {
        super.onCreate();

        queue = Volley.newRequestQueue(this);

        loader = new ImageLoader(queue, new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String url) {
                return null;
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {

            }
        });

    }

    public static void addToQueue(Request request){
        request.setTag("1");
        queue.add(request);
        queue.cancelAll("1");
    }
}
