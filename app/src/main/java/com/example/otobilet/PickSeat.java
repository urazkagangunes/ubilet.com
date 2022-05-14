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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    private List<String> koltuklar = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_seat);
        tanimla();
        btnOnClick();
        changeTitle();
        onClickTanimla();

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

    public void onClickTanimla() {
        koltukonClick(textView1);
        koltukonClick(textView2);
        koltukonClick(textView3);
        koltukonClick(textView4);
        koltukonClick(textView5);
        koltukonClick(textView6);
        koltukonClick(textView7);
        koltukonClick(textView8);
        koltukonClick(textView9);
        koltukonClick(textView10);
        koltukonClick(textView11);
        koltukonClick(textView12);
        koltukonClick(textView13);
        koltukonClick(textView14);
        koltukonClick(textView15);
        koltukonClick(textView16);
        koltukonClick(textView17);
        koltukonClick(textView18);
    }
    public void koltukonClick(TextView v) {

        switch (v.getId()){
            case R.id.textView1:
            case R.id.textView2:
            case R.id.textView3:
            case R.id.textView4:
            case R.id.textView5:
            case R.id.textView6:
            case R.id.textView7:
            case R.id.textView8:
            case R.id.textView9:
            case R.id.textView10:
            case R.id.textView11:
            case R.id.textView12:
            case R.id.textView13:
            case R.id.textView14:
            case R.id.textView15:
            case R.id.textView16:
            case R.id.textView17:
            case R.id.textView18:
                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        yapilacak(v);
                    }
                });
                break;
        }
    }

    public void yapilacak(TextView v) {
        ColorDrawable buttonColor = (ColorDrawable) v.getBackground();
        int color = buttonColor.getColor();
        if (color == Color.argb(255, 39, 149, 44)){
            v.setBackgroundColor(Color.argb(255, 243, 90, 90));
            for (int i = 0; i < koltuklar.size(); i++) {
                if (koltuklar.get(i).equals(v.getText().toString())) {
                    koltuklar.remove(i);
                }
            }
        }
        else {
            v.setBackgroundColor(Color.argb(255, 39, 149, 44));
            String koltuk = v.getText().toString();

            koltuklar.add(koltuk);
        }
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
                i.putExtra("koltuklar", (Serializable) koltuklar);
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
