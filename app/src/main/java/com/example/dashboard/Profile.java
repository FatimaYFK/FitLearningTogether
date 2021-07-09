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

public class Profile extends AppCompatActivity {

    private CalendarView calendarView1;
    private TextView myDate1;
    private TextInputLayout mydaten1;
    private FirebaseDatabase rootNoden1;
    private DatabaseReference referencen1;
    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        calendarView1 = (CalendarView) findViewById(R.id.calendarView4);
        myDate1 = (TextView) findViewById(R.id.myDate4);
        btn1 = (Button)findViewById(R.id.mybutton4);
        mydaten1 = findViewById(R.id.my_date4);

        calendarView1.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = dayOfMonth + "/" + (month + 1) + "/" + year;
                myDate1.setText(date);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootNoden1 = FirebaseDatabase.getInstance();
                referencen1 = rootNoden1.getReference("csdc");

                String val = mydaten1.getEditText().getText().toString();

                UserHelperClass helperClass = new UserHelperClass(val);
                referencen1.child(val).setValue(helperClass);
                Intent intent = new Intent(Profile.this,LoginDachboard.class);
                startActivity(intent);

            }
        });
    }
}