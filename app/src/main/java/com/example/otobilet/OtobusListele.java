package com.example.otobilet;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class OtobusListele extends AppCompatActivity {
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private String tarih;
    private String nereden;
    private String nereye;

    TextView[] textViewList = new TextView[] {textView1, textView2, textView3, textView4, textView5};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otobus_listele);
        changeTitle();
        tanimla();

        Bundle extras = getIntent().getExtras();
        tarih = extras.getString("tarih");
        nereden = extras.getString("nereden");
        nereye = extras.getString("nereye");

        textViewListener(textView1);
        textViewListener(textView2);
        textViewListener(textView3);
        textViewListener(textView4);
        textViewListener(textView5);

    }
    public void tanimla(){
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
    }
    public void textViewListener(TextView textView){
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(OtobusListele.this, PickSeat.class);
                    i.putExtra("tarih", tarih);
                    i.putExtra("otobus",textView.getText());
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