package com.example.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dashboard.calculator.Calculator;
import com.example.dashboard.notification.Wecker;
import com.example.dashboard.tictactoe.Tictac;
import com.example.dashboard.weather.view.ui.ActivityWeather;
import com.example.dashboard.weather.view.ui.SplashActivity;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tableLayout;
    private ViewPager viewPager;
    Button btn_Profile,btn_Greenhouse,btn_HTM,btn_ALL,btn_Education,btn_Goal, btn_calculator, btn_titac, btn_weather, btn_Notification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Notification = (Button) findViewById(R.id.buttonNotification);
        btn_weather= (Button) findViewById(R.id.buttonWeather);
        btn_titac = (Button) findViewById(R.id.ticTacToe);
        btn_Profile = (Button) findViewById(R.id.buttonProfile);
        btn_Greenhouse = (Button) findViewById(R.id.buttonGreenhouse);
        btn_HTM = (Button) findViewById(R.id.buttonHTM);
        btn_ALL = (Button) findViewById(R.id.buttonAll);
        btn_Education = (Button) findViewById(R.id.buttonEducation);
        btn_Goal = (Button) findViewById(R.id.buttonGoal);
        btn_calculator = (Button) findViewById(R.id.btnCalc) ;


        btn_Notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openNotification();
            }
        });

        btn_weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openWeather();
            }
        });
        btn_titac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openTictac();
            }
        });

        btn_calculator.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                openCalculator();
            }
        });

        btn_Education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            openEducation();
            }
        });

        btn_Goal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            openGoal();
            }
        });

    }

    private void openNotification() {
        Intent intent = new Intent(this, Wecker.class);
        startActivity(intent);
    }

    private void openWeather() {
        Intent intent = new Intent(this, SplashActivity.class);
        startActivity(intent);
    }

    private void openTictac() {
        Intent intent = new Intent(this, Tictac.class);
        startActivity(intent);
    }

    private void openCalculator() {
        Intent intent = new Intent(this, Calculator.class);
        startActivity(intent);
    }
    private void openedit() {
        Intent intent = new Intent(this, EditProfile.class);
        startActivity(intent);
    }

    private void openYourProfile() {
        Intent intent = new Intent(this, Yourprofil.class);
        startActivity(intent);
    }

    private void openGoal() {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }

    private void openEducation() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }


}