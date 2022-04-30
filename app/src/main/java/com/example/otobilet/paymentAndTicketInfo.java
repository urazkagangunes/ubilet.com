package com.example.otobilet;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class paymentAndTicketInfo extends AppCompatActivity {
    private String tarih;
    private TextView textView;
    private TextView textView19;
    private TextView textView20;
    private TextView textView21;
    private TextView textView22;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_and_ticket_info);
        changeTitle();
        tanimla();
        Bundle extras = getIntent().getExtras();
        tarih = extras.getString("tarih");
        textView20.setText(tarih);

    }
    public void tanimla(){
        textView = (TextView) findViewById(R.id.textView);
        textView19 = (TextView) findViewById(R.id.textView19);
        textView20 = (TextView) findViewById(R.id.textView20);
        textView21 = (TextView) findViewById(R.id.textView21);
        textView22 = (TextView) findViewById(R.id.textView22);
    }

    public void changeTitle() {
        this.setTitle("ubilet.com");
        ActionBar aBar;
        aBar = getSupportActionBar();
        ColorDrawable cd = new ColorDrawable(Color.RED);
        aBar.setBackgroundDrawable(cd);
    }
}