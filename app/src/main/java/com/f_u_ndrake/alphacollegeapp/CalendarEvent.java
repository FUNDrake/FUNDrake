package com.f_u_ndrake.alphacollegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.CalendarView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class CalendarEvent extends AppCompatActivity {

    CalendarView cal;
    TextView tvdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_event);
        Date currentTime = Calendar.getInstance().getTime();
        cal = (CalendarView)findViewById(R.id.calendarView);
        cal.setDate(new Date().getTime(),false,true);

    }
}
