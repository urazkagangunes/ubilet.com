package com.example.otobilet;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class paymentAndTicketInfo extends AppCompatActivity {
    private String tarih;
    private TextView textView;
    private TextView baslik2;
    private TextView tarihText;
    private TextView baslik3;
    private TextView ok;
    private String nereden;
    private String nereye;
    private TextView neredenText;
    private TextView nereyeText;
    private TextView marka;
    private String otobus;
    private TextView otobusBileti;
    private String name;
    private TextView adSoyad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_and_ticket_info);
        changeTitle();
        tanimla();
        Bundle extras = getIntent().getExtras();
        tarih = extras.getString("tarih");
        nereden = extras.getString("nereden");
        nereye = extras.getString("nereye");
        otobus = extras.getString("otobus");
        name = extras.getString("name");
        System.out.println(name);

        bilgileriAl();


    }
    public void tanimla(){
        textView = (TextView) findViewById(R.id.baslik);
        baslik2 = (TextView) findViewById(R.id.baslik2);
        tarihText = (TextView) findViewById(R.id.Tarih);
        baslik3 = (TextView) findViewById(R.id.baslik3);
        ok = (TextView) findViewById(R.id.ok);
        neredenText = (TextView) findViewById(R.id.nereden);
        nereyeText = (TextView) findViewById(R.id.nereye);
        marka = (TextView) findViewById(R.id.marka);
        marka.setBackgroundColor(Color.RED);
        otobusBileti = (TextView) findViewById(R.id.otobusBileti);
        adSoyad = (TextView) findViewById(R.id.adSoyad);

    }

    public void bilgileriAl(){
        tarihText.setText(tarih);
        neredenText.setText(nereden);
        nereyeText.setText(nereye);
        otobusBileti.setText(otobus);
        adSoyad.setText(name);
    }

    public void changeTitle() {
        this.setTitle("ubilet.com");
        ActionBar aBar;
        aBar = getSupportActionBar();
        ColorDrawable cd = new ColorDrawable(Color.RED);
        aBar.setBackgroundDrawable(cd);
    }
}