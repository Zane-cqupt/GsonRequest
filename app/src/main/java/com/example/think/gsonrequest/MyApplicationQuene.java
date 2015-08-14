package com.example.think.gsonrequest;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by think on 2015/8/13.
 */
public class MyApplicationQuene extends Application{
    private  static RequestQueue requestQueue;
    @Override
    public void onCreate() {
        super.onCreate();
        requestQueue = Volley.newRequestQueue(getApplicationContext());
    }

    /**
     * use a method to privode requestquene
     */
    public static RequestQueue getQueue(){
        return requestQueue;
    }
}
