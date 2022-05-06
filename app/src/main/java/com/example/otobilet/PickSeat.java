package com.example.otobilet;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PickSeat extends AppCompatActivity {
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
    private TextView textView8;
    private TextView textView9;
    private TextView textView10;
    private TextView textView11;
    private TextView textView12;
    private TextView textView13;
    private TextView textView14;
    private TextView textView15;
    private TextView textView16;
    private TextView textView17;
    private TextView textView18;
    private Button button1;
    private String tarih;
    private String otobus;
    private String nereden;
    private String nereye;

    private boolean tv0, tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9, tv10, tv11, tv12, tv13, tv14, tv15, tv16, tv17, tv18 = false;
    private boolean[] tvler = {tv0, tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9, tv10, tv11, tv12, tv13, tv14, tv15, tv16, tv17, tv18};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_seat);
        tanimla();
        pickSeater();
        btnOnClick();
        changeTitle();

        Bundle extras = getIntent().getExtras();
        otobus = extras.getString("otobus");
        tarih = extras.getString("tarih");
        nereden = extras.getString("nereden");
        nereye = extras.getString("nereye");


    }
    public void tanimla(){
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView6 = (TextView) findViewById(R.id.textView6);
        textView7 = (TextView) findViewById(R.id.textView7);
        textView8 = (TextView) findViewById(R.id.textView8);
        textView9 = (TextView) findViewById(R.id.textView9);
        textView10 = (TextView) findViewById(R.id.textView10);
        textView11 = (TextView) findViewById(R.id.textView11);
        textView12 = (TextView) findViewById(R.id.textView12);
        textView13 = (TextView) findViewById(R.id.textView13);
        textView14 = (TextView) findViewById(R.id.textView14);
        textView15 = (TextView) findViewById(R.id.textView15);
        textView16 = (TextView) findViewById(R.id.textView16);
        textView17 = (TextView) findViewById(R.id.textView17);
        textView18 = (TextView) findViewById(R.id.textView18);
        button1 = (Button) findViewById(R.id.button);
    }
    public void pickSeatListener(TextView textView, boolean tiklandimi) {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(tiklandimi);
                if (tiklandimi) {
                    textView.setBackgroundColor(Color.argb(100, 106, 106, 106));
                    int a = Integer.parseInt(String.valueOf(textView.getText()));
                    for (int i = 0; i < tvler.length; i++) {
                        if (a == i) {
                            tvler[i] = false;
                            System.out.println("truemış: " + tvler[i]);
                        }
                    }
                }
                else {
                    textView.setBackgroundColor(Color.argb(255, 39, 149, 44));
                    int a = Integer.parseInt(String.valueOf(textView.getText()));
                    for (int i = 0; i < tvler.length; i++) {
                        if (a == i) {
                            tvler[i] = true;
                            System.out.println("falsemış: " + tvler[i]);
                        }
                    }
                }
            }
        });
    }
    public void pickSeater(){
        pickSeatListener(textView1, tv1);
        pickSeatListener(textView2, tv2);
        pickSeatListener(textView3, tv3);
        pickSeatListener(textView4, tv4);
        pickSeatListener(textView5, tv5);
        pickSeatListener(textView6, tv6);
        pickSeatListener(textView7, tv7);
        pickSeatListener(textView8, tv8);
        pickSeatListener(textView9, tv9);
        pickSeatListener(textView10, tv10);
        pickSeatListener(textView11, tv11);
        pickSeatListener(textView12, tv12);
        pickSeatListener(textView13, tv13);
        pickSeatListener(textView14, tv14);
        pickSeatListener(textView15, tv15);
        pickSeatListener(textView16, tv16);
        pickSeatListener(textView17, tv17);
        pickSeatListener(textView18, tv18);


    }
    public void btnOnClick(){
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PickSeat.this, PaymentWindow.class);
                i.putExtra("tarih", tarih);
                i.putExtra("otobus", otobus);
                i.putExtra("nereden", nereden);
                i.putExtra("nereye", nereye);
                startActivity(i);
            }
        });
    }

    public void changeTitle() {
        this.setTitle("ubilet.com");
        ActionBar aBar;
        aBar = getSupportActionBar();
        ColorDrawable cd = new ColorDrawable(Color.RED);
        aBar.setBackgroundDrawable(cd);
    }
}