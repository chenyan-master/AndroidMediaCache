package com.huochat.mediacache.sample;

import android.app.Application;
import android.content.Context;

import com.huochat.mediacache.HttpProxyCacheServer;

/**
 * @author Alexey Danilov (huochat@gmail.com).
 */
public class App extends Application {

    private HttpProxyCacheServer proxy;

    public static HttpProxyCacheServer getProxy(Context context) {
        App app = (App) context.getApplicationContext();
        return app.proxy == null ? (app.proxy = app.newProxy()) : app.proxy;
    }

    private HttpProxyCacheServer newProxy() {
        return new HttpProxyCacheServer.Builder(this)
                .cacheDirectory(Utils.getVideoCacheDir(this))
                .build();
    }
}
