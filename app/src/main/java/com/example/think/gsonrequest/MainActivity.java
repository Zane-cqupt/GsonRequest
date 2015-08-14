package com.example.think.gsonrequest;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

public class MainActivity extends ActionBarActivity {

    private RequestQueue quene;


    private static final String url = "http://www.weather.com.cn/data/sk/101010100.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quene = MyApplicationQuene.getQueue();
        /**
         * 一定要添加泛型参数<Weather>
         */
        GsonRequest<Weather> gsonRequest = new GsonRequest<Weather>(url, Weather.class
                , new Response.Listener<Weather>() {
            @Override
            public void onResponse(Weather weather) {
                WeatherInfo weatherInfo = weather.getWeatherinfo();
                StringBuilder builder = new StringBuilder();
                builder.append(weatherInfo.getCity())
                        .append(" ")
                        .append(weatherInfo.getTemp())
                        .append("摄氏度 时间：")
                        .append(weatherInfo.getTime());

                Toast.makeText(MainActivity.this, builder, Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(MainActivity.this, String.valueOf(volleyError),
                        Toast.LENGTH_LONG).show();
            }
        });

        gsonRequest.setTag("firstGsonrequest");

        quene.add(gsonRequest);


    }




}
