package com.wendot.sinarsuryafurniture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreenActivity extends AppCompatActivity {

    TextView tv;
    int counter = 0;
    TimerTask tt;
    Timer t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        progress();
    }

    private void progress() {
        tv = (TextView)findViewById(R.id.loadingText);
        t = new Timer();
        tt = new TimerTask() {
            @Override
            public void run() {
                counter++;
                switch (counter){
                    case 30:
                        if(isConnected()) {
                            tv.setText("Establish Connection");
                        }else {
                            tv.setText("No Internet Connection");
                            t.cancel();
                        }
                        break;
                    case 40:
                        tv.setText("Checking for Updates");
                        break;
                    case 80:
                        tv.setText("Almost complete");
                        break;
                    case 90:
                        tv.setText("Starting Application");
                        break;
                    case 100:
                        t.cancel();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        break;
                }
            }
        };

        t.schedule(tt, 0, 100);
    }
    boolean isConnected(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if(networkInfo!=null){
            if(networkInfo.isConnected())
                return true;
            else
                return false;
        }else
            return false;

    }
}