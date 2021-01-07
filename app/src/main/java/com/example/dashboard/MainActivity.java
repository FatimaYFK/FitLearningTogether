package com.example.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button btn_Profile,btn_Greenhouse,btn_HTM,btn_ALL,btn_Education,btn_Goal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Profile = (Button) findViewById(R.id.buttonProfile);
        btn_Greenhouse = (Button) findViewById(R.id.buttonGreenhouse);
        btn_HTM = (Button) findViewById(R.id.buttonHTM);
        btn_ALL = (Button) findViewById(R.id.buttonAll);
        btn_Education = (Button) findViewById(R.id.buttonEducation);
        btn_Goal = (Button) findViewById(R.id.buttonGoal);



        btn_Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openProfile();
            }
        });


        btn_Greenhouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            openGreenhouse();
            }
        });

        btn_HTM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            openHTM();
            }
        });

        btn_ALL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            openAll();
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

    private void openedit() {
        Intent intent = new Intent(this, EditProfile.class);
        startActivity(intent);
    }

    private void openYourProfile() {
        Intent intent = new Intent(this, Yourprofil.class);
        startActivity(intent);
    }

    private void openGoal() {
        Intent intent = new Intent(this, Goal.class);
        startActivity(intent);
    }

    private void openEducation() {
        Intent intent = new Intent(this, Education.class);
        startActivity(intent);
    }

    private void openAll() {
        Intent intent = new Intent(this, All.class);
        startActivity(intent);
    }

    private void openHTM() {
        Intent intent = new Intent(this, HTM.class);
        startActivity(intent);
    }

    private void openGreenhouse() {
        Intent intent = new Intent(this, Greenhouse.class);
        startActivity(intent);
    }

    private void openProfile() {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }
}