package com.coolweather.android;


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.Build;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.coolweather.android.gson.Weather;
import com.coolweather.android.service.AutoUpdateService;
import com.coolweather.android.util.HttpUtil;
import com.coolweather.android.util.LogUtil;
import com.coolweather.android.util.Utility;
import com.coolweather.android.util.ViewUilt;

import org.w3c.dom.Text;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static com.coolweather.android.ChooseAreaFragment.WEATHER_ID_INTENT;
import static com.coolweather.android.util.AddressConstant.BING_PIC_ADDRESS_URL_BG;
import static com.coolweather.android.util.AddressConstant.WEATHER_ID_ADDRESS_URL;
import static com.coolweather.android.util.AddressConstant.WEATHER_ID_ADDRESS_URL_KEY;
import static com.coolweather.android.util.AddressConstant.WEATHER_ID_RESPONSE_STATUS_OK;

public class WeatherActivity extends BaseActivity {

    private static final String TAG = WeatherActivity.class.getSimpleName();
    private WeatherActivity activity;
    private ImageView bingPicImg;
    DrawerLayout mDrawerLayout;
    SwipeRefreshLayout swipeRefresh;
    private Button mNavButton;
    private ScrollView weatherLayoutScroll;
    private TextView titleCity;
    private TextView titleUpdateTime;
    private TextView degreeText;
    private TextView weatherInfoText;
    private LinearLayout forecastLayout;
    private TextView aqiText;
    private TextView pm25Text;
    private TextView comfortText;
    private TextView carWashText;
    private TextView sportText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        backgroundAndStatusBarMerging();
        setContentView(R.layout.activity_weather);
        activity = this;
        //初始化控件
        initView();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);
        String weatherString = prefs.getString("weather", null);
        String bingPic = prefs.getString("bing_pic", null);
        if (bingPic != null) {
            Glide.with(activity).load(bingPic).into(bingPicImg);
        } else {
            loadBingPic();
        }
        final String weatherId;
        if (weatherString != null) {
            //缓存中有数据，不用向网络请求
            Weather weather = Utility.handleWeatherResponse(weatherString);
            weatherId = weather.getBasic().getId();
            showWeatherInfo(weather);
        } else {
            //无缓存时，去服务器查询天气
            weatherId = getIntent().getStringExtra(WEATHER_ID_INTENT);
            weatherLayoutScroll.setVisibility(View.INVISIBLE);
            requestWeather(weatherId);
        }
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                LogUtil.d(TAG, "onRefresh weatherId "+weatherId);
                requestWeather(weatherId);
            }
        });

        mNavButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void backgroundAndStatusBarMerging() {
        //由于这个功能再Android5.0及以上的系统才支持
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            LogUtil.d(TAG, "backgroundAndStatusBarMerging" );
            Window window = getWindow();
            window.getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }
    }

    private void initView() {
        bingPicImg = ViewUilt.findViewById(activity, R.id.bing_pic_img);

        mDrawerLayout = ViewUilt.findViewById(activity, R.id.drawer_layout);
        mNavButton = ViewUilt.findViewById(activity, R.id.nav_home_button);
        swipeRefresh = ViewUilt.findViewById(activity, R.id.swipe_refresh);
        //设置刷新图标的颜色
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);

        weatherLayoutScroll = ViewUilt.findViewById(activity, R.id.weather_layout_scroll);
        titleCity = ViewUilt.findViewById(activity, R.id.title_city);
        titleUpdateTime = ViewUilt.findViewById(activity, R.id.title_update_time);
        degreeText = ViewUilt.findViewById(activity, R.id.degree_text);
        weatherInfoText = ViewUilt.findViewById(activity, R.id.weather_info_text);
        forecastLayout = ViewUilt.findViewById(activity, R.id.forecast_layout);
        aqiText = ViewUilt.findViewById(activity, R.id.aqi_text);
        pm25Text = ViewUilt.findViewById(activity, R.id.pm25_text);
        comfortText = ViewUilt.findViewById(activity, R.id.comfort_text);
        carWashText = ViewUilt.findViewById(activity, R.id.car_wash_text);
        sportText = ViewUilt.findViewById(activity, R.id.sport_text);
    }

    private void loadBingPic() {
        HttpUtil.sendOkHttpRequest(BING_PIC_ADDRESS_URL_BG, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String bingPic = response.body().string();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(activity).
                                load(bingPic).into(bingPicImg);

                    }
                });
                SharedPreferences.Editor editor = PreferenceManager.
                        getDefaultSharedPreferences(activity).edit();
                editor.putString("bing_pic", bingPic);
                editor.apply();
            }
        });
    }


    public void requestWeather(String weatherId) {
        loadBingPic();
        String weatherUrl = WEATHER_ID_ADDRESS_URL + weatherId + WEATHER_ID_ADDRESS_URL_KEY;
        LogUtil.d("Utility", " requestWeather weatherUrl " + weatherUrl);
        HttpUtil.sendOkHttpRequest(weatherUrl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.d(TAG, "onFailure ");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(activity, "获取天气信息失败", Toast.LENGTH_SHORT).show();
                    }
                });
                swipeRefresh.setRefreshing(false);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseText = response.body().string();
                final Weather weather = Utility.handleWeatherResponse(responseText);
                LogUtil.d(TAG, "onResponse weather " + (weather == null));
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (weather != null
                                && WEATHER_ID_RESPONSE_STATUS_OK.equals(weather.getStatus())) {
                            //将服务器返回的数据缓存到SharedPreferences当中，
                            SharedPreferences.Editor edit = PreferenceManager.
                                    getDefaultSharedPreferences(activity).edit();
                            edit.putString("weather", responseText);
                            edit.apply();
                            //显示Weather中的数据
                            showWeatherInfo(weather);
                        } else {
                            Toast.makeText(activity, "获取天气信息失败", Toast.LENGTH_SHORT).show();
                        }
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        });
        loadBingPic();
    }

    private void showWeatherInfo(Weather weather) {
        LogUtil.d(TAG, "showWeatherInfo weather.toString() " + weather.getBasic().getCity());
        titleCity.setText(weather.getBasic().getCity());
        titleUpdateTime.setText(weather.getBasic().getUpdate().getLoc().split(" ")[1]);
        degreeText.setText(weather.getNow().getTmp() + "℃");
        weatherInfoText.setText(weather.getNow().getCond().getTxt());
        //从forecastLayout中移除所有子视图
        forecastLayout.removeAllViews();
        for (Weather.DailyForecastBean dailyForecastBean :
                weather.getDaily_forecast()) {
            View view = LayoutInflater.from(activity).
                    inflate(R.layout.forecast_item, forecastLayout, false);
            TextView dateText = ViewUilt.findViewById(view, R.id.date_text);
            TextView infoText = ViewUilt.findViewById(view, R.id.info_text);
            TextView maxText = ViewUilt.findViewById(view, R.id.max_text);
            TextView minText = ViewUilt.findViewById(view, R.id.min_text);
            dateText.setText(dailyForecastBean.getDate());
            infoText.setText(dailyForecastBean.getCond().getCode_n());
            maxText.setText(dailyForecastBean.getTmp().getMax());
            minText.setText(dailyForecastBean.getTmp().getMin());
            forecastLayout.addView(view);
        }
        if (weather.getAqi() != null) {
            aqiText.setText(weather.getAqi().getCity().getAqi());
            pm25Text.setText(weather.getAqi().getCity().getPm25());
        }

        String comfort = "舒适度：" + weather.getSuggestion().getComf().getTxt();
        String carWash = "洗车指数：" + weather.getSuggestion().getCw().getTxt();
        String sport = "运动建议：" + weather.getSuggestion().getSport().getTxt();
        comfortText.setText(comfort);
        carWashText.setText(carWash);
        sportText.setText(sport);
        weatherLayoutScroll.setVisibility(View.VISIBLE);
        //启动服务更新数据
        Intent intent = new Intent(activity, AutoUpdateService.class);
        startService(intent);
    }
}
