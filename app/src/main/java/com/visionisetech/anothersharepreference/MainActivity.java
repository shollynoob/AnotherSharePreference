package com.visionisetech.anothersharepreference;

import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Toolbar mtoolbar;
    Button mRedColor, mGreenColor, mYellowColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtoolbar = (Toolbar) findViewById(R.id.toolbar);
        mRedColor = (Button) findViewById(R.id.butred);
        mGreenColor = (Button) findViewById(R.id.butgreen);
        mYellowColor = (Button) findViewById(R.id.butyellow);

        mtoolbar.setTitle(getResources().getString(R.string.app_name));
        if (getColor() != getResources().getColor(R.color.colorPrimary)){
            mtoolbar.setBackgroundColor(getColor());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(getColor());
            }
        }

        mRedColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mtoolbar.setBackgroundColor(getResources().getColor(R.color.colorRed));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.colorRed));
                }
                storeColor(getResources().getColor(R.color.colorRed));
            }
        });

        mGreenColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mtoolbar.setBackgroundColor(getResources().getColor(R.color.colorGreen));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.colorGreen));
                }
                storeColor(getResources().getColor(R.color.colorGreen));
            }
        });
        mYellowColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mtoolbar.setBackgroundColor(getResources().getColor(R.color.colorYellow));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.colorYellow));
                }
                storeColor(getResources().getColor(R.color.colorYellow));
            }
        });
    }

    private void storeColor(int color){
        SharedPreferences msharedPreferences = getSharedPreferences("toolbarColor", MODE_PRIVATE);
        SharedPreferences.Editor meditor = msharedPreferences.edit();
        meditor.putInt("color", color);
        meditor.apply();

    }

    private int getColor(){
        SharedPreferences msharedPreferences = getSharedPreferences("toolbarColor", MODE_PRIVATE);
        int selectedColor= msharedPreferences.getInt("color", getResources().getColor(R.color.colorPrimary));
        return selectedColor;
    }
}
