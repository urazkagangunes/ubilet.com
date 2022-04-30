package com.example.otobilet;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PaymentWindow extends AppCompatActivity {

    private TextView bilgiAl, iletisimBilgileri, yolcuBilgileri, kartBilgileri, kartNumarasi, cartSdk, cvcInfo;
    private EditText emailAddress, personName, kimlikNumarasi,inputCardInfo, editTextDate, cvc, editTextPhone;
    private Button button3;
    private String tarih;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_window);
        changeTitle();
        tanimla();
        onClickBtn();
        Bundle extras = getIntent().getExtras();
        tarih = extras.getString("tarih");
        bilgiAl.setText(extras.getString("otobus") + "\n" + tarih);
    }
    public void tanimla(){
        bilgiAl = (TextView) findViewById(R.id.bilgiAl);
        iletisimBilgileri = (TextView) findViewById(R.id.IletisimBilgileri);
        yolcuBilgileri = (TextView) findViewById(R.id.yolcuBilgileri);
        kartBilgileri = (TextView) findViewById(R.id.kartBilgileri);
        kartNumarasi = (TextView) findViewById(R.id.kartNumarasi);
        cartSdk = (TextView) findViewById(R.id.cardSkt);
        cvcInfo = (TextView) findViewById(R.id.cvcInfo);
        emailAddress = (EditText) findViewById(R.id.emailAddress);
        personName =(EditText) findViewById(R.id.personName);
        kimlikNumarasi = (EditText) findViewById(R.id.kimlikNumarasi);
        inputCardInfo = (EditText) findViewById(R.id.inputCardInfo);
        editTextDate = (EditText) findViewById(R.id.editTextDate);
        cvc = (EditText) findViewById(R.id.cvc);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        button3 = (Button) findViewById(R.id.button3);
    }
    public void onClickBtn(){
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PaymentWindow.this,paymentAndTicketInfo.class);
                i.putExtra("tarih", tarih);
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