package com.example.finance;

import static com.example.finance.utils.MessageUtils.sendMessage;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.finance.api.AlarmApi;
import com.example.finance.api.StockApi;
import com.example.finance.api.UserApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class StartSplash extends AppCompatActivity {

    private Long sleepInterval = 1000 * 1800L;
    private Long splashShowTime = 2000L;
    private String userId = "";
    private Map<String, Object> userData;
    private List<Map<String, Object>> alarmData;
    private List<Map<String, Object>> stockData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取发短信权限
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 1);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.start_splash);

        SharedPreferences settings = getSharedPreferences("AppInfo", MODE_PRIVATE);

        SharedPreferences.Editor editor = settings.edit();

        editor.putString("isAlive", "1");
        editor.apply();
        Thread myThread = new Thread() {//创建子线程
            @Override
            public void run() {
                try {
                    sleep(splashShowTime);
                    SharedPreferences settings1 = getSharedPreferences("AppInfo", 0);


                    /*
                    Thread warningListener = new Thread() {//创建子线程
                        @Override
                        public void run() {
                            SharedPreferences settings = getSharedPreferences("UserInfo", 0);
                            userId = settings.getString("UserId", "").toString();
                            if (!userId.isEmpty()) {
                                try {
                                    alarmData = (List<Map<String, Object>>) (AlarmApi.GetAlarm(userId).getData());
                                    userData = (Map<String, Object>) UserApi.GetDataById(userId).getData();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                                System.out.println("警告");
                                System.out.println(alarmData);

                                final String[] isAliveStr = {settings1.getString("isAlive", "").toString()};
                                final boolean[] isAppAlive = {Objects.equals(isAliveStr[0], "1")};
                                ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
                                scheduler.scheduleAtFixedRate(() -> {
                                    stockData = new ArrayList<>();
                                    System.out.println("开始");
                                    // 获取用户监听的自选股并对比，若超过阈值，则发送短信
                                    for (Map<String, Object> alarmDatum : alarmData) {
                                        try {
                                            Map<String, Object> res1 = (Map<String, Object>) StockApi.GetLatest((String) alarmDatum.get("tsCode")).getData();
                                            stockData.add(res1);
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    StringBuilder stringBuilder = new StringBuilder();
                                    for (int i = 0; i < stockData.size(); i++) {
                                        if (((Integer) stockData.get(i).get("low") < (Integer) alarmData.get(i).get("low")) || (Integer) stockData.get(i).get("change") < (Integer) alarmData.get(i).get("change")) {
                                            if (stringBuilder.length() > 0) {
                                                stringBuilder.append(",");
                                            }
                                            stringBuilder.append(stockData.get(i).get("tsCode"));
                                        }
                                    }
                                    if(!(stringBuilder.length() == 0)) {
                                        boolean send = sendMessage((String) userData.get("userPhone"), null, "你所关注的股票 " + stringBuilder.toString() + " 的最低价/涨跌幅已跌破预警值，请及时关注。", null, null);
                                        Looper.prepare();
                                        if (send) {
                                            Toast.makeText(getApplicationContext(), "短信发送成功", Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(getApplicationContext(), "短信发送失败", Toast.LENGTH_LONG).show();
                                        }
                                        Looper.loop();
                                    }


                                    isAliveStr[0] = settings1.getString("isAlive", "").toString();
                                    isAppAlive[0] = Objects.equals(isAliveStr[0], "1");
                                    if(!isAppAlive[0]) {
                                        throw new RuntimeException();
                                    }
                                }, 0, sleepInterval, TimeUnit.MILLISECONDS);

                            }
                        }
                    };*//*
                    warningListener.start();
                    // 确保只有一个监听线程
                    String isWarningListenerRunningStr = settings1.getString("isWarningListenerRunning", "").toString();
                    if (!Objects.equals(isWarningListenerRunningStr, "1")) {
                        warningListener.start();

                        SharedPreferences.Editor editor = settings1.edit();

                        editor.putString("isWarningListenerRunning", "1");
                        editor.apply();
                    }*/
                    Intent it = new Intent(getApplicationContext(), StockMainPage.class);//启动MainActivity
                    intentActivityResultLauncher.launch(it);
                    //finish();//关闭当前活动
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();//启动线程
    }

    ActivityResultLauncher<Intent> intentActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            //此处是跳转的result回调方法
            if (result.getResultCode() == RESULT_CANCELED || (result.getData() != null && result.getResultCode() == Activity.RESULT_OK)) {
                SharedPreferences settings = getSharedPreferences("AppInfo", MODE_PRIVATE);

                SharedPreferences.Editor editor = settings.edit();

                editor.clear();
                editor.apply();
            }
        }
    });
}
