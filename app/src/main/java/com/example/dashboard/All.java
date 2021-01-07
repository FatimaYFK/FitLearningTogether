package com.example.dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class All extends AppCompatActivity {

    private CalendarView calendarView;
    private TextView myDate;
    private TextInputLayout mydaten;
    private FirebaseDatabase rootNoden;
    private DatabaseReference referencen;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);
        calendarView = (CalendarView) findViewById(R.id.calendarView1);
        myDate = (TextView) findViewById(R.id.myDate1);
        btn = (Button)findViewById(R.id.mybutton1);
        mydaten = findViewById(R.id.my_date1);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = dayOfMonth + "/" + (month + 1) + "/" + year;
                myDate.setText(date);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootNoden = FirebaseDatabase.getInstance();
                referencen = rootNoden.getReference("mydate");

                String val = mydaten.getEditText().getText().toString();

                UserHelperClass helperClass = new UserHelperClass(val);
                referencen.child(val).setValue(helperClass);
                Intent intent = new Intent(All.this,MainActivity.class);
                startActivity(intent);

            }
        });
    }
}