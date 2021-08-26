package com.example.finnkinoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView mDisplayDate, mDisplayTime;
    private Spinner spinner;
    private ScrollView scrollView;
    DatePickerDialog.OnDateSetListener mDateSetListener;
    TimePickerDialog.OnTimeSetListener mTimeSetListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDisplayDate = (TextView) findViewById(R.id.btnDate);
        mDisplayTime = (TextView) findViewById(R.id.btnTime);
        spinner = (Spinner) findViewById(R.id.spinner);
        scrollView = (ScrollView) findViewById(R.id.scrollView2);
        System.out.println("HALOO!!!!!!!!!!!");
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy
                .Builder()
                .permitAll()
                .build();
        StrictMode.setThreadPolicy(policy);
        TheatreRequest tr = new TheatreRequest();
        ArrayList<String> spinnerList = tr.getTheatreInfo();
        ArrayList<String> idList = tr.getTheatreId();
        System.out.println("ID LIST: " +idList);
        theatreSelection(spinnerList, idList);
        System.out.println(mDisplayDate);
    }


    @SuppressLint("SetTextI18n")
    public void datePicker(View v) {
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                mDisplayDate.setText(dayOfMonth + "." + (monthOfYear + 1) + "." + year);
                            }
                        }, year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                datePickerDialog.show();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void timePicker(View v) {
        mDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cal = Calendar.getInstance();
                int hour = cal.get(Calendar.HOUR);
                int minute = cal.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, mTimeSetListener, hour, minute, true);
                timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mDisplayTime.setText(hour + "." + minute);
                timePickerDialog.show();
            }
        });
    }

    public void theatreSelection(ArrayList<String> spinnerList, ArrayList<String> idList) {
        System.out.println("SPINNER?");
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, spinnerList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("Parent: " +parent+ " position: " +position+ " id: "+id);
                moviesByTheatre(spinnerList.get(position), idList.get(position));
                //stuff here to handle item selection
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void moviesByTheatre(String theatreName, String theatreId){
        Context context = getApplicationContext();
        String date = mDisplayDate.getText().toString();
        date = date.replace( "\n", "" );
        date = date.replace( " ", "" );
        String URL = "https://www.finnkino.fi/xml/Schedule/?area="+theatreId+"&dt="+date;
        System.out.println(URL);
        if (date.length() < 1){
            Toast toast = Toast.makeText(context, "HUOM! PVM EI SYÖTETTY!", Toast.LENGTH_LONG);
            toast.show();
        }
        TheatreInfo ti = new TheatreInfo();
        ArrayList<String> showsInTheatre = ti.getList(URL);
        LinearLayout ll = (LinearLayout) this.findViewById(R.id.linlay);
        TextView tv = new TextView(this);
        if (showsInTheatre.size() > 0) {
            String listString = "";
            for (String s : showsInTheatre)
            {
                listString += s + "\n";
            }
            tv.setText(listString);
            ll.addView(tv);
        }


    }
}
