package com.example.bottledispenser;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static BottleDispenser bd = null;

    public void bottleDispenser(String[] args) {

        int choice = 0;
        int currentValue;
        BottleDispenser bd = new BottleDispenser();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do {
            bd.dispenserMenu();
            try {
                choice = Integer.parseInt(br.readLine());
            }catch (IOException ex){
                System.out.println("Error");
            }
            switch (choice){
                case 1:
                    bd.addMoney();
                    break;
                case 2:
                    bd.dispenserProducts();
                    break;
                case 3:
                    bd.returnMoney();
                    break;
                case 4:
                    bd.dispenserProducts();
                    break;
            }

        }while (choice != 0);
        bd.returnMoney();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        TextView addAmount = (TextView) findViewById(R.id.addAmount);
        BottleDispenser bd = new BottleDispenser();
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, bd.getlist());
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        int currentValue = seekBar.getProgress();
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(getBaseContext(), "Raha määrä: " +progress, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getBaseContext(), "Valitse raha määrä vetämällä!", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getBaseContext(), "Hyväksy määrä painamalla Deposit!", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void Deposit(View v){
        BottleDispenser bd = new BottleDispenser();
        bd.addMoney();
    }
    public void Buy(View v){
        BottleDispenser bd = new BottleDispenser();
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String text = spinner.getSelectedItem().toString();
        if (text == "Pepsi 0,5l"){
            bd.buyBottle(1);
        }
        else if (text == "Pepsi 1,5l"){
            bd.buyBottle(2);
        }
        else if (text == "Coca-Cola Zero 0,5l"){
            bd.buyBottle(3);
        }
        else if (text == "Coca-Cola Zero 1,5l"){
            bd.buyBottle(4);
        }
        else if (text == "Fanta Zero 0,5l"){
            bd.buyBottle(5);
        }



    }

}